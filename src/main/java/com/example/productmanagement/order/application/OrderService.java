package com.example.productmanagement.order.application;

import com.example.productmanagement.order.dto.request.CreateOrderRequest;
import com.example.productmanagement.order.dto.response.CreateOrderResponse;
import com.example.productmanagement.order.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);

    List<OrderResponse> getOrdersByUser(String email);

    void deleteOrder(Long orderId);
}
