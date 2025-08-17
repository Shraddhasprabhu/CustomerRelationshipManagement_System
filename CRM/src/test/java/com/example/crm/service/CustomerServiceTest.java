package com.example.crm.service;

import com.example.crm.dao.CustomerRepository;
import com.example.crm.entities.Customer;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer1, customer2, customer3;

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all CustomerService tests...");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.out.println("Before each test...");

        customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Ramesh Kumar");
        customer1.setEmail("ramesh.kumar@example.com");
        customer1.setPhone("9876543210");
        customer1.setAddress("MG Road, Bengaluru");
        customer1.setCreatedDate(LocalDate.of(2024, 1, 5));

        customer2 = new Customer();
        customer2.setId(2L);
        customer2.setName("Shraddha Patil");
        customer2.setEmail("shraddha.patil@example.com");
        customer2.setPhone("9123456780");
        customer2.setAddress("FC Road, Pune");
        customer2.setCreatedDate(LocalDate.of(2024, 3, 12));

        customer3 = new Customer();
        customer3.setId(3L);
        customer3.setName("Parneet Singh");
        customer3.setEmail("parneet.singh@example.com");
        customer3.setPhone("9988776655");
        customer3.setAddress("Sector 17, Chandigarh");
        customer3.setCreatedDate(LocalDate.of(2024, 5, 25));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all CustomerService tests...");
    }

    @Test
    void testAddCustomer() {
        when(customerRepository.save(customer1)).thenReturn(customer1);

        Customer saved = customerService.addCustomer(customer1);

        assertNotNull(saved);
        assertEquals("Ramesh Kumar", saved.getName());
        assertEquals("ramesh.kumar@example.com", saved.getEmail());
    }

    @Test
    void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2, customer3));

        List<Customer> customers = customerService.getAllCustomers();

        assertNotNull(customers);
        assertEquals(3, customers.size());
        assertTrue(customers.contains(customer2));
    }

    @Test
    void testGetCustomerById_Found() {
        when(customerRepository.findById(2L)).thenReturn(Optional.of(customer2));

        Customer found = customerService.getCustomerById(2L);

        assertNotNull(found);
        assertEquals("Shraddha Patil", found.getName());
        assertEquals("shraddha.patil@example.com", found.getEmail());
    }

    @Test
    void testGetCustomerById_NotFound() {
        when(customerRepository.findById(9L)).thenReturn(Optional.empty());

        Customer notFound = customerService.getCustomerById(9L);

        assertNull(notFound);
    }

    @Test
    void testUpdateCustomer_Found() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer2);

        Customer updated = customerService.updateCustomer(1L, customer2);

        assertNotNull(updated);
        assertEquals("Shraddha Patil", updated.getName());
        assertEquals("shraddha.patil@example.com", updated.getEmail());
    }

    @Test
    void testUpdateCustomer_NotFound() {
        when(customerRepository.findById(9L)).thenReturn(Optional.empty());

        Customer result = customerService.updateCustomer(99L, customer3);

        assertNull(result);
    }

    @Test
    void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
        verify(customerRepository, times(1)).deleteById(1L);
    }
}
