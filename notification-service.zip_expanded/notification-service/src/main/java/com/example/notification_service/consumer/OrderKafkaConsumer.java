package com.example.notification_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.notification_service.model.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderKafkaConsumer {

    @KafkaListener(
            topics = "order-created",
            groupId = "notification-group"
    )
    public void consumeOrder(OrderCreatedEvent event) {

        log.info("======================================");
        log.info("New Order Received");
        log.info("Order ID     : {}", event.getOrderId());
        log.info("Customer     : {}", event.getCustomerName());
        log.info("Product      : {}", event.getProduct());
        log.info("Amount       : {}", event.getAmount());
        log.info("Notification : Order confirmation sent");
        log.info("======================================");
    }
}
