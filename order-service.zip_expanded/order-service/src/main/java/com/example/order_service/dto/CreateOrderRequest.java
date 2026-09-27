package com.example.order_service.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

	private String customerName;
	private String product;
	private double amount;
}