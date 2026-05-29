
package com.eventdrivereportgenration.report.eventdto;

public class ReportGeneratedEvent {

    private Long reportId;
    private String userId;
    private String reportType;
    private String status;

    public ReportGeneratedEvent() {
    }

    public ReportGeneratedEvent(Long reportId,
                                String userId,
                                String reportType,
                                String status) {
        this.reportId = reportId;
        this.userId = userId;
        this.reportType = reportType;
        this.status = status;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}