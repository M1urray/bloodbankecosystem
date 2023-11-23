package com.example.bloodbank.repository;

import com.example.bloodbank.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    //Add custom query if needed

}