package com.example.productmanagement.order.application;

import com.example.productmanagement.order.dto.request.CreateOrderRequest;

public interface OrderService {

    void createOrder(CreateOrderRequest createOrderRequest);
}
