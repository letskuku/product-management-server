package com.example.productmanagement.order.dto.response;

import com.example.productmanagement.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateOrderResponse {

    private final String productName;
    private final String userName;
    private final String email;
    private final Long quantity;
    private final Long totalPrice;

    @Builder
    public CreateOrderResponse(String productName, String userName, String email, Long quantity, Long totalPrice) {
        this.productName = productName;
        this.userName = userName;
        this.email = email;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static CreateOrderResponse fromEntity(Order order) {
        return CreateOrderResponse.builder()
                .productName(order.getProduct().getName())
                .userName(order.getUser().getName())
                .email(order.getUser().getEmail())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
