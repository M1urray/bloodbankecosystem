package com.example.bloodbank.controller;

import com.example.bloodbank.dtos.DonorDto;
import com.example.bloodbank.entity.Donor;
import com.example.bloodbank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<Map<String, Object>> addDonor(@RequestBody DonorDto donorDto) {
        Map<String, Object> response = donorService.addDonor(donorDto);

        if ((boolean) response.get("success")) {
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    //endpoint 2
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllDonors(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size) {
        Map<String, Object> response = new HashMap<>();

        Pageable pageable = PageRequest.of(page, size);
        Page<Donor> donorPage = donorService.getAllDonors(pageable);

        if (donorPage.isEmpty()) {
            response.put("success", false);
            response.put("message", "Donors not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("success", true);
        response.put("message", "Donor data retrieved successfully.");
        response.put("data", donorPage.getContent());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //endpoint 3
    @GetMapping("/{donorId}")
    public ResponseEntity<Object> getDonorById(@PathVariable Long donorId) {
        Map<String, Object> response = new HashMap<>();

        Optional<Donor> optionalDonor = donorService.getDonorById(donorId);

        if (optionalDonor.isEmpty()) {
            response.put("success", false);
            response.put("message", "Donor not found with ID: " + donorId);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("success", true);
        response.put("message", "Donor data retrieved successfully.");
        response.put("data", optionalDonor.get());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
