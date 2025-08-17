package com.example.crm.service;

import com.example.crm.dao.ReportRepository;
import com.example.crm.entities.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    // Add new report
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    // Retrieve all reports
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Retrieve report by ID
    public Report getReportById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.orElse(null);
    }

    // Update report
    public Report updateReport(Long id, Report updatedReport) {
        Optional<Report> existingReportOptional = reportRepository.findById(id);
        if (existingReportOptional.isPresent()) {
            Report existingReport = existingReportOptional.get();
            existingReport.setReportName(updatedReport.getReportName());
            existingReport.setDescription(updatedReport.getDescription());
            existingReport.setGeneratedDate(updatedReport.getGeneratedDate());
            return reportRepository.save(existingReport);
        } else {
            System.out.println("Report not found with ID: " + id);
            return null;
        }
    }

    // Delete report
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
