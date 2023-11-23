package com.example.bloodbank.repository;

import com.example.bloodbank.entity.BloodBag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBagRepository extends JpaRepository<BloodBag, Long> {
    //Add custom query if needed
}
