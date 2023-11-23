package com.example.bloodbank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "donors")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donorId;

    @Column(name = "full_name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "medical_history", length = 1000) // Adjust length as needed
    private String medicalHistory;

    // Constructors

    public Donor() {

    }

}