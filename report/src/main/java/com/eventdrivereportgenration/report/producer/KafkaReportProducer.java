package com.eventdrivereportgenration.report.producer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaReportProducer {

    private static final String TOPIC = "report.generated";

    @Autowired
    private KafkaTemplate<String, ReportGeneratedEvent> kafkaTemplate;

    public void publishReportGeneratedEvent(ReportGeneratedEvent event) {
        kafkaTemplate.send(TOPIC, event);
        System.out.println("Event Published Successfully! ID: " + event.getReportId());
    }
}