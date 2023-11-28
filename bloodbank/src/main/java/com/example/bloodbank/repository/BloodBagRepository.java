package com.example.bloodbank.repository;

import com.example.bloodbank.entity.BloodBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BloodBagRepository extends JpaRepository<BloodBag, Long> {
    Optional<BloodBag> findByDonatedAtAndBloodType(LocalDate donatedAt, String bloodType);
    //Add custom query if needed
}
