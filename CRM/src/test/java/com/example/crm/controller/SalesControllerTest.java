package com.example.crm.controller;

import com.example.crm.entities.Customer;
import com.example.crm.entities.Sales;
import com.example.crm.service.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SalesControllerTest {

    @Mock
    private SalesService salesService;

    @InjectMocks
    private SalesController salesController;

    private Customer customer1;
    private Customer customer2;
    private Sales sale1;
    private Sales sale2;
    private Sales sale3;

    @BeforeEach
    void setUp() {
        // Mock Customers
        customer1 = new Customer();
        customer1.setId(101L);
        customer1.setName("Ramesh Kumar");
        customer1.setEmail("ramesh.kumar@example.com");

        customer2 = new Customer();
        customer2.setId(102L);
        customer2.setName("Shraddha Prabhu");
        customer2.setEmail("shraddha.prabhu@example.com");

        // Mock Sales
        sale1 = new Sales(new BigDecimal("15000.00"),
                LocalDate.of(2024, 2, 5),
                "CRM Software Subscription",
                customer1);
        sale1.setId(1L);

        sale2 = new Sales(new BigDecimal("25000.50"),
                LocalDate.of(2024, 4, 18),
                "Data Analytics Tool",
                customer2);
        sale2.setId(2L);

        sale3 = new Sales(new BigDecimal("32000.75"),
                LocalDate.of(2024, 6, 30),
                "Inventory Management Suite",
                customer1);
        sale3.setId(3L);
    }

    @Test
    void testAddSale() {
        when(salesService.addSale(sale1)).thenReturn(sale1);

        Sales result = salesController.addSale(sale1);

        assertNotNull(result);
        assertEquals("CRM Software Subscription", result.getProductName());
        assertEquals(customer1.getName(), result.getCustomer().getName());
        verify(salesService, times(1)).addSale(sale1);
    }

    @Test
    void testGetAllSales() {
        List<Sales> salesList = Arrays.asList(sale1, sale2, sale3);
        when(salesService.getAllSales()).thenReturn(salesList);

        List<Sales> result = salesController.getAllSales();

        assertEquals(3, result.size());
        assertTrue(result.stream().anyMatch(s -> s.getCustomer().getName().equals("Shraddha Prabhu")));
        verify(salesService, times(1)).getAllSales();
    }

    @Test
    void testGetSaleById_Found() {
        when(salesService.getSaleById(2L)).thenReturn(sale2);

        Sales result = salesController.getSaleById(2L);

        assertNotNull(result);
        assertEquals("Data Analytics Tool", result.getProductName());
        assertEquals("Shraddha Prabhu", result.getCustomer().getName());
        verify(salesService, times(1)).getSaleById(2L);
    }

    @Test
    void testGetSaleById_NotFound() {
        when(salesService.getSaleById(9L)).thenReturn(null);

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> salesController.getSaleById(9L));

        assertEquals("Sale not found with ID: 9", ex.getMessage());
        verify(salesService, times(1)).getSaleById(9L);
    }

    @Test
    void testUpdateSale() {
        when(salesService.updateSale(3L, sale3)).thenReturn(sale3);

        Sales result = salesController.updateSale(3L, sale3);

        assertEquals("Inventory Management Suite", result.getProductName());
        assertEquals(customer1.getName(), result.getCustomer().getName());
        verify(salesService, times(1)).updateSale(3L, sale3);
    }

    @Test
    void testDeleteSale() {
        salesController.deleteSale(1L);
        verify(salesService, times(1)).deleteSale(1L);
    }
}
