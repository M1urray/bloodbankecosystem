package com.example.bloodbank.controller;

import com.example.bloodbank.service.BloodBagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/bloodbags")
public class BloodBagController {

    private final BloodBagService bloodBagService;



    @Autowired
    public BloodBagController(BloodBagService bloodBagService) {
        this.bloodBagService = bloodBagService;
    }

    //endpoint 7
    @GetMapping("/all")
    public ResponseEntity<Object> getAllBloodBags() {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of retrieving all blood bags ");
        return ResponseEntity.ok(response);
    }
}
