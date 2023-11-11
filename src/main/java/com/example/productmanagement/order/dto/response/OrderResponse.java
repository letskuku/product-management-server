package com.example.productmanagement.order.dto.response;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.product.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderResponse {

    private final String userName;
    private final String productName;
    private final Category category;
    private final Long price;
    private final Long quantity;
    private final Long totalPrice;

    @Builder
    public OrderResponse(String userName, String productName, Category category, Long price, Long quantity, Long totalPrice) {
        this.userName = userName;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
                .userName(order.getUser().getName())
                .productName(order.getProduct().getName())
                .category(order.getProduct().getCategory())
                .price(order.getProduct().getPrice())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .build();
    }
}
