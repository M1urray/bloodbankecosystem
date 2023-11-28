package com.example.bloodbank.service;

import com.example.bloodbank.dtos.DonationDto;
import com.example.bloodbank.entity.BloodBag;
import com.example.bloodbank.entity.Donation;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.repository.BloodBagRepository;
import com.example.bloodbank.repository.DonationRepository;
import com.example.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final DonorRepository donorRepository;
    private final BloodBagRepository bloodBagRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodBagRepository bloodBagRepository) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodBagRepository = bloodBagRepository;
    }
    public Map<String, Object> addDonation(DonationDto donationDto) {
        Map<String, Object> responseMap = new HashMap<>();

        Long donorId = donationDto.getDonorId();
        int qty =  donationDto.getQty();

        if (donorId == null ) {
            responseMap.put("success", false);
            responseMap.put("message", "Donor Id cannot be empty.");
            return responseMap;
        }
        if (qty <= 0) {
            responseMap.put("success", false);
            responseMap.put("message", "Quantity cannot be less than zero");
            return responseMap;
        }
        if (qty > 470) {
            responseMap.put("success", false);
            responseMap.put("message", "Invalid donation quantity. Maximum allowed quantity is 470 ml.");
            return responseMap;
        }

        Optional<Donor> donorOptional = donorRepository.findById(donorId);
        if (!donorOptional.isPresent()) {
            responseMap.put("success", false);
            responseMap.put("message", "Donor not found with id: " + donorId);
            return responseMap;
        }

        @SuppressWarnings("OptionalGetWithoutIsPresent") Donor donor = donorOptional.get();

        int donorAge = donor.getAge();
        if (donorAge < 18 || donorAge > 65) {
            responseMap.put("success", false);
            responseMap.put("message", "Donor is not within the eligible age range (18-65).");
            return responseMap;
        }

        // Step 5: Check the last donation date and ensure eligibility based on a 56-day waiting period
        LocalDate lastDonationDate = calculateLastDonationDate(donationDto.getDonorId());
        if (lastDonationDate != null && lastDonationDate.plusDays(56).isAfter(LocalDate.now())) {
            responseMap.put("success", false);
            responseMap.put("message", "Donor is not eligible to donate yet. Waiting period not met.");
            return responseMap;
        }



        // Step 7: Create a new donation record
        Donation donation = new Donation();
        donor.setDonorId(donorId); // Assuming you have setDonorId method in the Donor entity
        donation.setDonor(donor);
        donation.setQty(qty);
        donation.setDonatedAt(LocalDate.now());
        donation.setBloodType(donor.getBloodType());

        // Step 8: Save the donation record in the "donations" table
        donation = donationRepository.save(donation);

        // Step 9: Manage blood bags by updating or creating new records in the "blood_bags" table
        manageBloodBags(donation);

        // Step 10: Prepare and return the response

        responseMap.put("donationId", donation.getDonationId());
        responseMap.put("donorId", donation.getDonor().getDonorId());
        responseMap.put("donatedAt", donation.getDonatedAt());
        responseMap.put("qty", donation.getQty());
        responseMap.put("bloodType", donation.getBloodType());

        return responseMap;
    }

    private void manageBloodBags(Donation donation) {
        // Step 1: Find an existing blood bag that matches the donation date and blood type
        Optional<BloodBag> existingBloodBag = bloodBagRepository.findByDonatedAtAndBloodType(
                donation.getDonatedAt(), donation.getBloodType());

        if (existingBloodBag.isPresent()) {
            // Step 2a: Update the quantity of the existing blood bag
            BloodBag bloodBag = existingBloodBag.get();
            bloodBag.setQty(bloodBag.getQty() + donation.getQty());
            bloodBagRepository.save(bloodBag);
        } else {
            // Step 2b: Create a new blood bag
            BloodBag newBloodBag = new BloodBag();
            newBloodBag.setBloodType(donation.getBloodType());
            newBloodBag.setQty(donation.getQty());
            newBloodBag.setDonatedAt(donation.getDonatedAt());
            bloodBagRepository.save(newBloodBag);
        }
    }

    private LocalDate calculateLastDonationDate(Long donorId) {
        // Retrieve the last donation date for the given donorId from the donations table
        Donor donor = new Donor();
        donor.setDonorId(donorId);
        Donation lastDonation = donationRepository.findTopByDonorOrderByDonatedAtDesc(donor);

        if (lastDonation != null) {
            return lastDonation.getDonatedAt();
        }

        // Return null if no previous donation record is found
        return null;
    }


}
