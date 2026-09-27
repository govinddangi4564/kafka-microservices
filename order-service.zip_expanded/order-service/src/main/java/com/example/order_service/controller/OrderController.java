package com.example.order_service.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.dto.CreateOrderRequest;
import com.example.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
		String orderId = orderService.createOrder(request);

		return ResponseEntity.ok(
                Map.of(
                        "message", "Order created successfully",
                        "orderId", orderId
                )
        );
	}
}
