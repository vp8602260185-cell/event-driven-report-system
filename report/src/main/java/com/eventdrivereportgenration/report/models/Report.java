package com.eventdrivereportgenration.report.models;

import jakarta.persistence.*;



@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private String userId;
    private String reportType;
    private String status;

    public Report(String userId, String reportType, String status) {
        this.userId = userId;
        this.reportType = reportType;
        this.status = status;
    }
    public Report() {}
    public Long getReportId() {
        return reportId;
    }

    public String getUserId() {
        return userId;
    }

    public String getReportType() {
        return reportType;
    }

    public String getStatus() {
        return status;
    }

}
