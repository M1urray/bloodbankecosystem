package com.example.bloodbank.service;

import com.example.bloodbank.repository.BloodBagRepository;
import com.example.bloodbank.repository.DonationRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DonorService {
    private final DonationRepository donationRepository;
    private final BloodBagRepository bloodBagRepository;
@Autowired
    public DonorService(DonationRepository donationRepository, BloodBagRepository bloodBagRepository) {
        this.donationRepository = donationRepository;
        this.bloodBagRepository = bloodBagRepository;
    }
}
