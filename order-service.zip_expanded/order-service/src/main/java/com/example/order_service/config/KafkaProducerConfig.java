package com.example.order_service.config;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.order_service.model.OrderCreatedEvent;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

    /**
     * Creates the topic for order events
     */
    @Bean
    public NewTopic orderCreatedTopic() {
        return TopicBuilder
                .name("order-created")
                .partitions(3)
                .replicas(1)
                .build();
    }

    /**
     * Defines the ProducerFactory for Kafka
     */
    @Bean
    public ProducerFactory<String, OrderCreatedEvent> producerFactory() {
        return new DefaultKafkaProducerFactory<>(
            new org.springframework.kafka.core.DefaultKafkaProducerFactory<>(
                Map.of(
                    org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
                    org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                    org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class
                )
            ).getConfigurationProperties()
        );
    }

    /**
     * Creates the KafkaTemplate bean that OrderService depends on
     */
    @Bean
    public KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}