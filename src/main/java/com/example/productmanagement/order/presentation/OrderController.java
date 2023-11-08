package com.example.productmanagement.order.presentation;

import com.example.productmanagement.order.application.OrderService;
import com.example.productmanagement.order.dto.request.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {

        orderService.createOrder(createOrderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
