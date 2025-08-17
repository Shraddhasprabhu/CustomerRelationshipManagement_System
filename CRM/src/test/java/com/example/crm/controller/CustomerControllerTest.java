package com.example.crm.controller;

import com.example.crm.entities.Customer;
import com.example.crm.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    void setUp() {
        customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Ramesh Kumar");
        customer1.setEmail("ramesh.kumar@example.com");
        customer1.setPhone("9876543210");
        customer1.setAddress("Delhi");
        customer1.setCreatedDate(LocalDate.of(2024, 6, 1));

        customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Shraddha Prabhu");
        customer2.setEmail("shraddha.prabhu@example.com");
        customer2.setPhone("9123456780");
        customer2.setAddress("Mumbai");
        customer2.setCreatedDate(LocalDate.of(2024, 7, 15));
    }

    @Test
    void testAddCustomer() {
        when(customerService.addCustomer(customer1)).thenReturn(customer1);

        Customer result = customerController.addCustomer(customer1);

        assertNotNull(result);
        assertEquals("Ramesh Kumar", result.getName());
        assertEquals("ramesh.kumar@example.com", result.getEmail());
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = Arrays.asList(customer1, customer2);
        when(customerService.getAllCustomers()).thenReturn(customers);

        List<Customer> result = customerController.getAllCustomers();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertSame(customers, result);
        assertEquals("Shraddha Prabhu", result.get(1).getName());
    }

    @Test
    void testGetCustomerById() {
        when(customerService.getCustomerById(1L)).thenReturn(customer1);

        Customer result = customerController.getCustomerById(1L);

        assertNotNull(result);
        assertEquals("Ramesh Kumar", result.getName());
        assertEquals("Delhi", result.getAddress());
    }

    @Test
    void testUpdateCustomer() {
        when(customerService.updateCustomer(2L, customer2)).thenReturn(customer2);

        Customer result = customerController.updateCustomer(2L, customer2);

        assertNotNull(result);
        assertEquals("Shraddha Prabhu", result.getName());
        assertEquals("Mumbai", result.getAddress());
    }

    @Test
    void testDeleteCustomer() {
        customerController.deleteCustomer(2L);
        verify(customerService, times(1)).deleteCustomer(2L);
    }
}
