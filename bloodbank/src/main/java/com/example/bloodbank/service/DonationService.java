package com.example.bloodbank.service;

import com.example.bloodbank.repository.BloodBagRepository;
import com.example.bloodbank.repository.DonationRepository;
import com.example.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
