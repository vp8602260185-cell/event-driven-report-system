package com.eventdrivereportgenration.report.producer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaReportProducer {

    private static final String TOPIC = "report.generated";

    private final KafkaTemplate<String, ReportGeneratedEvent> kafkaTemplate;

    // Constructor injection guarantees Spring maps the exact generic types correctly
    public KafkaReportProducer(KafkaTemplate<String, ReportGeneratedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishReportGeneratedEvent(ReportGeneratedEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Event Published Successfully! ID: " + event.getReportId());
    }
}
