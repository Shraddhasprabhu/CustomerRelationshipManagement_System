package com.example.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crm.entities.Sales;
import com.example.crm.service.SalesService;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    // POST
    @PostMapping
    public Sales addSale(@RequestBody Sales sale) {
        return salesService.addSale(sale);
    }

    // GET all
    @GetMapping
    public List<Sales> getAllSales() {
        return salesService.getAllSales();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Sales getSaleById(@PathVariable Long id) {
        Sales sale = salesService.getSaleById(id);
        if (sale == null) {
            throw new RuntimeException("Sale not found with ID: " + id);
        }
        return sale;
    }

    // PUT
    @PutMapping("/{id}")
    public Sales updateSale(@PathVariable Long id, @RequestBody Sales sale) {
        return salesService.updateSale(id, sale);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        salesService.deleteSale(id);
    }
}
