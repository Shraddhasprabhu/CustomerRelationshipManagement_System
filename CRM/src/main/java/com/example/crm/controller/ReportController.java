package com.example.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crm.entities.Report;
import com.example.crm.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // POST
    @PostMapping
    public Report addReport(@RequestBody Report report) {
        return reportService.addReport(report);
    }

    // GET all
    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable Long id) {
        Report report = reportService.getReportById(id);
        if (report == null) {
            throw new RuntimeException("Report not found with ID: " + id);
        }
        return report;
    }

    // PUT
    @PutMapping("/{id}")
    public Report updateReport(@PathVariable Long id, @RequestBody Report report) {
        return reportService.updateReport(id, report);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}
