package com.example.bloodbank.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "blood_bags")
public class BloodBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bloodBagId;

    @Column(name = "donated_at")
    private LocalDate donatedAt;

    @Column(name = "qty")
    private int qty;

    @Column(name = "blood_type")
    private String bloodType;

    // Constructors

    public BloodBag() {
    }

    // Getters and Setters

    public Long getBloodBagId() {
        return bloodBagId;
    }

    public void setBloodBagId(Long bloodBagId) {
        this.bloodBagId = bloodBagId;
    }

    public LocalDate getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(LocalDate donatedAt) {
        this.donatedAt = donatedAt;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
