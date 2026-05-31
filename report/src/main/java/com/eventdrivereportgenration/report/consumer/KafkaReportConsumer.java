package com.eventdrivereportgenration.report.consumer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.stereotype.Service;

@Service
public class KafkaReportConsumer {

    @KafkaListener(
            topics = "report.generated",
            groupId = "report-group"
    )
    @RetryableTopic(attempts = "5")
    public void consume1(ReportGeneratedEvent event) {
        System.out.println("Modify report: " + event.getReportId());
        throw new RuntimeException("Simulated failure in consume1");
    }

    @DltHandler
    public void handleDlt(ReportGeneratedEvent event) {

        System.out.println("DLT Received : " + event.getReportId());

        // Save to DB
        // Send alert
        // Create incident
    }

}