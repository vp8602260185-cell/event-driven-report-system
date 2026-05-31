package com.eventdrivereportgenration.report.consumer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaReportConsumer {

    @KafkaListener(
            topics = "report.generated",
            groupId = "report-group"
    )
    public void consume1(ReportGeneratedEvent event) {
        System.out.println("Sending Mail : " + event.getReportId());
        System.out.println("Event Consumed : " + event.getReportId());
    }

}