package com.example.bloodbank.service;

import com.example.bloodbank.repository.BloodBagRepository;
import com.example.bloodbank.repository.BloodUsageRepository;
import com.example.bloodbank.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodUsageService {

    private final BloodUsageRepository bloodUsageRepository;
    private final BloodBagRepository bloodBagRepository;
    private final DonorRepository donorRepository;

    @Autowired
    public BloodUsageService(BloodUsageRepository bloodUsageRepository, BloodBagRepository bloodBagRepository, DonorRepository donorRepository) {
        this.bloodUsageRepository = bloodUsageRepository;
        this.bloodBagRepository = bloodBagRepository;
        this.donorRepository = donorRepository;
    }


}