package com.example.productmanagement.order.application;

import com.example.productmanagement.order.dto.request.CreateOrderRequest;
import com.example.productmanagement.order.dto.response.CreateOrderResponse;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
}
