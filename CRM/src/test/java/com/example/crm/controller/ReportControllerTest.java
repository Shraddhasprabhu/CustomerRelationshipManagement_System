package com.example.crm.controller;

import com.example.crm.entities.Report;
import com.example.crm.service.ReportService;
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
public class ReportControllerTest {

    @Mock
    private ReportService reportService;

    @InjectMocks
    private ReportController reportController;

    private Report report1;
    private Report report2;
    private Report report3;

    @BeforeEach
    void setUp() {
        report1 = new Report();
        report1.setId(1L);
        report1.setReportName("Annual Sales Report");
        report1.setDescription("Prepared by Ramesh Kumar");
        report1.setGeneratedDate(LocalDate.of(2024, 1, 15));

        report2 = new Report();
        report2.setId(2L);
        report2.setReportName("Customer Feedback Report");
        report2.setDescription("Compiled by Shraddha Prabhu");
        report2.setGeneratedDate(LocalDate.of(2024, 3, 10));

        report3 = new Report();
        report3.setId(3L);
        report3.setReportName("Inventory Status Report");
        report3.setDescription("Reviewed by Swizal Janice");
        report3.setGeneratedDate(LocalDate.of(2024, 6, 20));
    }

    @Test
    void testAddReport() {
        when(reportService.addReport(report1)).thenReturn(report1);

        Report result = reportController.addReport(report1);

        assertNotNull(result);
        assertEquals("Annual Sales Report", result.getReportName());
        assertTrue(result.getDescription().contains("Ramesh Kumar"));
    }

    @Test
    void testGetAllReports() {
        List<Report> reports = Arrays.asList(report1, report2, report3);
        when(reportService.getAllReports()).thenReturn(reports);

        List<Report> result = reportController.getAllReports();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Customer Feedback Report", result.get(1).getReportName());
        assertTrue(result.get(1).getDescription().contains("Shraddha Prabhu"));
    }

    @Test
    void testGetReportById() {
        when(reportService.getReportById(3L)).thenReturn(report3);

        Report result = reportController.getReportById(3L);

        assertNotNull(result);
        assertEquals("Inventory Status Report", result.getReportName());
        assertTrue(result.getDescription().contains("Swizal Janice"));
    }

    @Test
    void testUpdateReport() {
        when(reportService.updateReport(2L, report2)).thenReturn(report2);

        Report result = reportController.updateReport(2L, report2);

        assertNotNull(result);
        assertEquals("Customer Feedback Report", result.getReportName());
        assertTrue(result.getDescription().contains("Shraddha Prabhu"));
    }

    @Test
    void testDeleteReport() {
        reportController.deleteReport(1L);
        verify(reportService, times(1)).deleteReport(1L);
    }
}
