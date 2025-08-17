package com.example.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crm.entities.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // Example: List<Report> findByReportNameContainingIgnoreCase(String name);
}
