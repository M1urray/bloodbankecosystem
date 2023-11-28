package com.example.bloodbank.controller;

import com.example.bloodbank.dtos.DonationDto;
import com.example.bloodbank.service.DonationService;
import com.example.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;
    private final DonorService donorService;

    @Autowired
    public DonationController(DonationService donationService,DonorService donorService) {
        this.donationService = donationService;
        this.donorService=donorService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addDonation(@RequestBody DonationDto donationDto) {
        try {
            return ResponseEntity.ok(donationService.addDonation(donationDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //endpoint 5
    @GetMapping("/all")
    public ResponseEntity<Object> getAllDonations() {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of retrieving   all donations  ");
        return ResponseEntity.ok(response);
    }

    //endpoint 6
    @GetMapping("/history/{donorId}")
    public ResponseEntity<Object> getDonationHistory(@PathVariable Long donorId) {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of retrieving history of donations for  donor using donorId ");
        return ResponseEntity.ok(response);
    }

}
