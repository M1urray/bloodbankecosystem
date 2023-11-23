package com.example.bloodbank.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long donationId;

    @ManyToOne
    @JoinColumn(name = "donor_id") // Use the actual foreign key column name
    private Donor donor;


    @Column(name = "qty")
    private int qty;

    @Column(name = "donated_at")
    private LocalDate donatedAt;

    @Column(name = "blood_type")
    private String bloodType;

    // Constructors

    public Donation() {
    }


    // Getters and Setters

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(LocalDate donatedAt) {
        this.donatedAt = donatedAt;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
