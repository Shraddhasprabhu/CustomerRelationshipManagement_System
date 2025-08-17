package com.example.crm.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDate saleDate;
    private String productName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // --- Getters & Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public LocalDate getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // --- Constructors ---
    public Sales() {}
    public Sales(BigDecimal amount, LocalDate saleDate, String productName, Customer customer) {
        this.amount = amount;
        this.saleDate = saleDate;
        this.productName = productName;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Sales [id=" + id + ", amount=" + amount + ", saleDate=" + saleDate + ", productName=" + productName + "]";
    }
}
