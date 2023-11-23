package com.example.bloodbank.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DonorDto {
    public String name;
    public String phoneNumber;
    public String address;
    public LocalDate dateOfBirth;
    public String gender;
    public String bloodType;
    public String medicalHistory;

    //Constructor

    public DonorDto() {

    }
}
