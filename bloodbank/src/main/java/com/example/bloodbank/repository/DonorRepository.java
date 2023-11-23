package com.example.bloodbank.repository;

import com.example.bloodbank.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

    //Add custom query if needed
    Optional<Donor> findById(Long Id);
    Page<Donor> findAll(Pageable pageable);
}
