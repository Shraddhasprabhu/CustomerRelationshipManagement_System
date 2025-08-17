
package com.example.crm.service;

import com.example.crm.dao.CustomerRepository;
import com.example.crm.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Add a new customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Retrieve a customer by ID
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    // Update existing customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(id);
        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            existingCustomer.setName(updatedCustomer.getName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setCreatedDate(updatedCustomer.getCreatedDate());
            return customerRepository.save(existingCustomer);
        } else {
            System.out.println("Customer not found with ID: " + id);
            return null;
        }
    }

    // Delete customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
