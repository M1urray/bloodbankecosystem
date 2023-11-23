package com.example.bloodbank.controller;

import com.example.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/donors")
public class DonorController {
    private final DonorService donorService;

    @Autowired
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    //endpoint 1
    @PostMapping
    public ResponseEntity<Object> addDonor() {

        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of adding donor");
        return ResponseEntity.ok(response);
    }

    //endpoint 2
    @GetMapping
    public ResponseEntity<Object> getAllDonors() {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of retrieving all donors ");
        return ResponseEntity.ok(response);
    }

    //endpoint 3
    @GetMapping("/{donorId}")
    public ResponseEntity<Object> getDonorById(@PathVariable Long donorId) {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of retrieving  donor using donorId ");
        return ResponseEntity.ok(response);
    }
}
