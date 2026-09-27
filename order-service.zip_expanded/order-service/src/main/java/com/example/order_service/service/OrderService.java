package com.example.order_service.service;

import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.model.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

	private static final String TOPIC = "order-created";

	public String createOrder(CreateOrderRequest request) {

		String orderId = UUID.randomUUID().toString();

		OrderCreatedEvent event = new OrderCreatedEvent(orderId, request.getCustomerName(), request.getProduct(),
				request.getAmount());

		kafkaTemplate.send(TOPIC, orderId, event);

		return orderId;
	}

}
