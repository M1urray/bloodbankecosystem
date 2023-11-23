package com.example.bloodbank.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDate usedAt) {
        this.usedAt = usedAt;
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

    public Long getBloodBagId() {
        return bloodBagId;
    }

    public void setBloodBagId(Long bloodBagId) {
        this.bloodBagId = bloodBagId;
    }
}

