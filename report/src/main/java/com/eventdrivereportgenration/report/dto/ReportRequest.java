package com.eventdrivereportgenration.report.dto;

public class ReportRequest {

    private String userId;
    private String reportType;

    public ReportRequest() {
    }

    public ReportRequest(String userId, String reportType) {
        this.userId = userId;
        this.reportType = reportType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}