
package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crm.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    // Example: List<Sales> findByCustomerId(Long customerId);
}
