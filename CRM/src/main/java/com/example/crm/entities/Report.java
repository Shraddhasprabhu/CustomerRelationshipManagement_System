package com.example.crm.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reports")
public class Report {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportName;
    private String description;
    private LocalDate generatedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getGeneratedDate() {
		return generatedDate;
	}
	public void setGeneratedDate(LocalDate generatedDate) {
		this.generatedDate = generatedDate;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", reportName=" + reportName + ", description=" + description + ", generatedDate="
				+ generatedDate + "]";
	}
	public Report(Long id, String reportName, String description, LocalDate generatedDate) {
		super();
		this.id = id;
		this.reportName = reportName;
		this.description = description;
		this.generatedDate = generatedDate;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    

}
