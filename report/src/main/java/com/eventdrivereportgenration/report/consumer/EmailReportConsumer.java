package com.eventdrivereportgenration.report.consumer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailReportConsumer {

    @KafkaListener(
            topics = "report.generated",
            groupId = "email-group"
    )
    public void consumeForEmail(ReportGeneratedEvent event) {
        System.out.println("EmailConsumer - Sending email to user: " + event.getUserId());
    }

}
