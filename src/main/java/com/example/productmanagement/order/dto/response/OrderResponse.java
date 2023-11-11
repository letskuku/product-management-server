package com.example.productmanagement.order.dto.response;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.product.domain.Category;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderResponse {

    private final Long orderId;
    private final String userName;
    private final String productName;
    private final Category category;
    private final Long price;
    private final Long quantity;
    private final Long totalPrice;
    private final LocalDateTime createdAt;
    private final Boolean isActivated;

    @Builder
    public OrderResponse(Long orderId, String userName, String productName, Category category,
                         Long price, Long quantity, Long totalPrice, LocalDateTime createdAt, Boolean isActivated) {
        this.orderId = orderId;
        this.userName = userName;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.isActivated = isActivated;
    }

    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
                .orderId(order.getId())
                .userName(order.getUser().getName())
                .productName(order.getProduct().getName())
                .category(order.getProduct().getCategory())
                .price(order.getProduct().getPrice())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .createdAt(order.getCreatedAt())
                .isActivated(order.getIsActivated())
                .build();
    }
}
