package com.example.productmanagement.order.dto.response;

import com.example.productmanagement.order.domain.Order;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateOrderResponse {

    private final String productName;
    private final String userName;
    private final Long quantity;
    private final Long totalPrice;

    @Builder
    public CreateOrderResponse(String productName, String userName, Long quantity, Long totalPrice) {
        this.productName = productName;
        this.userName = userName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static CreateOrderResponse fromEntity(Order order) {
        return CreateOrderResponse.builder()
                .productName(order.getProduct().getName())
                .userName(order.getUser().getName())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
