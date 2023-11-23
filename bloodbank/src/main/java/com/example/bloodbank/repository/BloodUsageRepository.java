package com.example.bloodbank.repository;

import com.example.bloodbank.entity.BloodUsage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodUsageRepository extends JpaRepository<BloodUsage, Long> {
    //Add custom query if needed
}
