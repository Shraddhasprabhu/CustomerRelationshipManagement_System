
package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crm.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom query methods here, e.g.:
    // List<Customer> findByNameContainingIgnoreCase(String name);
}
