package com.example.bloodbank.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "blood_usages")
public class BloodUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "used_at")
    private LocalDate usedAt;

    @Column(name = "qty")
    private int qty;

    @Column(name = "blood_type")
    private String bloodType;

    private Long bloodBagId;

    // Constructors

    public BloodUsage() {
    }


    // Getters and Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsedAt(LocalDate usedAt) {
        this.usedAt = usedAt;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setBloodBagId(Long bloodBagId) {
        this.bloodBagId = bloodBagId;
    }
}

