package com.eventdrivereportgenration.report.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic reportGeneratedTopic() {
        return TopicBuilder.name("report.generated")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic reportFailedTopic() {
        return TopicBuilder.name("report.failed")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
