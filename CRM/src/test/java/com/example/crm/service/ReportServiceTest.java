package com.example.crm.service;

import com.example.crm.dao.ReportRepository;
import com.example.crm.entities.Report;
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

class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    private Report report1, report2, report3;

    @BeforeAll
    static void setupAll() {
        System.out.println("Before all ReportService tests...");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        System.out.println("Before each test...");

        report1 = new Report();
        report1.setId(1L);
        report1.setReportName("Ramesh Kumar Sales Summary");
        report1.setDescription("Monthly sales performance for Ramesh Kumar.");
        report1.setGeneratedDate(LocalDate.of(2024, 6, 30));

        report2 = new Report();
        report2.setId(2L);
        report2.setReportName("Shraddha Patil Interaction Report");
        report2.setDescription("All interactions with Shraddha Patil during Q3 2024.");
        report2.setGeneratedDate(LocalDate.of(2024, 7, 15));

        report3 = new Report();
        report3.setId(3L);
        report3.setReportName("Parneet Singh Annual Overview");
        report3.setDescription("Annual performance and customer satisfaction analysis for Parneet Singh.");
        report3.setGeneratedDate(LocalDate.of(2024, 8, 10));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test...");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all ReportService tests...");
    }

    @Test
    void testAddReport() {
        when(reportRepository.save(report1)).thenReturn(report1);

        Report saved = reportService.addReport(report1);

        assertNotNull(saved);
        assertEquals("Ramesh Kumar Sales Summary", saved.getReportName());
        assertTrue(saved.getDescription().contains("Ramesh Kumar"));
    }

    @Test
    void testGetAllReports() {
        when(reportRepository.findAll()).thenReturn(Arrays.asList(report1, report2, report3));

        List<Report> reports = reportService.getAllReports();

        assertNotNull(reports);
        assertEquals(3, reports.size());
        assertTrue(reports.contains(report2));
    }

    @Test
    void testGetReportById_Found() {
        when(reportRepository.findById(2L)).thenReturn(Optional.of(report2));

        Report found = reportService.getReportById(2L);

        assertNotNull(found);
        assertEquals("Shraddha Patil Interaction Report", found.getReportName());
    }

    @Test
    void testGetReportById_NotFound() {
        when(reportRepository.findById(9L)).thenReturn(Optional.empty());

        Report notFound = reportService.getReportById(99L);

        assertNull(notFound);
    }

    @Test
    void testUpdateReport_Found() {
        when(reportRepository.findById(1L)).thenReturn(Optional.of(report1));
        when(reportRepository.save(any(Report.class))).thenReturn(report2);

        Report updated = reportService.updateReport(1L, report2);

        assertNotNull(updated);
        assertEquals("Shraddha Patil Interaction Report", updated.getReportName());
    }

    @Test
    void testUpdateReport_NotFound() {
        when(reportRepository.findById(9L)).thenReturn(Optional.empty());

        Report result = reportService.updateReport(9L, report3);

        assertNull(result);
    }

    @Test
    void testDeleteReport() {
        reportService.deleteReport(1L);
        verify(reportRepository, times(1)).deleteById(1L);
    }
}
