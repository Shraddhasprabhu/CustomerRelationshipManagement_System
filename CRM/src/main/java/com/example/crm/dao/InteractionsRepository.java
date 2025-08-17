package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crm.entities.Interactions;

public interface InteractionsRepository extends JpaRepository<Interactions, Long> {
    // Example: List<Interaction> findByCustomerId(Long customerId);
}
