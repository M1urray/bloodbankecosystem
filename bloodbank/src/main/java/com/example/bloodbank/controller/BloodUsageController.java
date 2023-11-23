package com.example.bloodbank.controller;

import com.example.bloodbank.service.BloodUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/bloodusage")
public class BloodUsageController {

    private final BloodUsageService bloodUsageService;

    @Autowired
    public BloodUsageController(BloodUsageService bloodUsageService) {
        this.bloodUsageService = bloodUsageService;
    }

    //endpoint 8
    @PostMapping("/request")
    public ResponseEntity<Object> requestBlood(@RequestBody Map<String, Object> request) {
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", "placeholder for logic of requesting blood from blood bank ");
        return ResponseEntity.ok(response);
    }
}
