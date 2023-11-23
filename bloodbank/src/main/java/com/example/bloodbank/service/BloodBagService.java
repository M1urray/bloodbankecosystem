package com.example.bloodbank.service;

import com.example.bloodbank.repository.BloodBagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodBagService {

    private final BloodBagRepository bloodBagRepository;

    @Autowired
    public BloodBagService( BloodBagRepository bloodBagRepository) {

        this.bloodBagRepository = bloodBagRepository;
    }
}
