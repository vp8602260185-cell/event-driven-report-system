package com.eventdrivereportgenration.report.consumer;

import com.eventdrivereportgenration.report.eventdto.ReportGeneratedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RecommendationReportConsumer {

    @KafkaListener(
            topics = "report.generated",
            groupId = "recommendation-group"
    )
    public void consumeForRecommendation(ReportGeneratedEvent event) {
        System.out.println("RecommendationConsumer - Generating recommendations for user: " + event.getUserId());
        
    }

}
