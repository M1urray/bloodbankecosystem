package com.example.bloodbank.service;

import com.example.bloodbank.dtos.DonorDto;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.repository.DonorRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DonorService {
    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Map<String, Object> addDonor(DonorDto donorDto) {
        Map<String, Object> responseMap = new HashMap<>();

        // Check for incomplete data
        if (StringUtils.isAnyBlank(donorDto.getName(), donorDto.getPhoneNumber(), donorDto.getBloodType())) {
            responseMap.put("success", false);
            responseMap.put("message", "Donor information is incomplete.");
            return responseMap;
        }

        // Check for valid phone number
        if (!isValidPhoneNumber(donorDto.getPhoneNumber())) {
            responseMap.put("success", false);
            responseMap.put("message", "Phone number is not valid.");
            return responseMap;
        }

        // Check for valid blood type
        if (!isValidBloodType(donorDto.getBloodType())) {
            responseMap.put("success", false);
            responseMap.put("message", "Blood type is not valid.");
            return responseMap;
        }

        // Check if phone number is unique
        if (donorRepository.findByPhoneNumber(donorDto.getPhoneNumber()).isPresent()) {
            responseMap.put("success", false);
            responseMap.put("message", "Phone number is already in use by another donor.");
            return responseMap;
        }

        // All validations passed, add donor to the repository
        Donor donor = new Donor();
        donor.setName(donorDto.getName());
        donor.setPhoneNumber(donorDto.getPhoneNumber());
        donor.setAddress(donorDto.getAddress());
        donor.setGender(donorDto.getGender());
        donor.setDateOfBirth(donorDto.getDateOfBirth());
        donor.setMedicalHistory(donorDto.getMedicalHistory());
        donor.setBloodType(donorDto.getBloodType());
        Donor savedDonor = donorRepository.save(donor);

        responseMap.put("success", true);
        responseMap.put("message", "Donor added successfully.");
        responseMap.put("data", savedDonor);

        return responseMap;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        // useing regular expressions logic to check if the phone number is valid
        return phoneNumber.matches("\\d{10}");
    }

    private boolean isValidBloodType(String bloodType) {
        // use a list of valid blood types logic to check if the blood type is valid

        List<String> validBloodTypes = Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
        return validBloodTypes.contains(bloodType);
    }
    public Page<Donor> getAllDonors(Pageable pageable) {
        return donorRepository.findAll(pageable);
    }
    public Optional<Donor> getDonorById(Long donorId) {
        return donorRepository.findById(donorId);
    }
}
