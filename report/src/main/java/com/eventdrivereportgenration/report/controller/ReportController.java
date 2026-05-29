package com.eventdrivereportgenration.report.controller;

import com.eventdrivereportgenration.report.dto.ReportRequest;
import com.eventdrivereportgenration.report.dto.ReportResponse;
import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import com.eventdrivereportgenration.report.models.Report;
import com.eventdrivereportgenration.report.producer.KafkaReportProducer;
import com.eventdrivereportgenration.report.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/report")
public class ReportController {

    @Autowired
    private  ReportRepository reportRepository;

    @Autowired
    private KafkaReportProducer kafkaReportProducer;

    @GetMapping("/{reportId}")
    public String getReport(@PathVariable String reportId) {

        return "Here is your report for reportId : " + reportId;
    }

    @PostMapping("/generate")
    public ReportResponse generateReport(@RequestBody ReportRequest request) {


        // 1. Save report in DB
        Report report = new Report(
                request.getUserId(),
                request.getReportType(),
                "PENDING"
        );

        reportRepository.save(report);

        // 2. Publish Kafka event
        ReportGeneratedEvent event = new ReportGeneratedEvent(
                report.getReportId(),
                report.getUserId(),
                report.getReportType(),
                report.getStatus()
        );

        kafkaReportProducer.publishReportGeneratedEvent(event);

        return new ReportResponse(
                report.getReportId().toString(),
                request.getUserId(),
                request.getReportType(),
                "GENERATED"
        );
    }
}