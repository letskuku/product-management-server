package com.example.productmanagement.order.dto.request;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.product.domain.Product;
import com.example.productmanagement.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateOrderRequest {

    private final Long productId;
    private final String email;
    private final Long quantity;

    @Builder
    public CreateOrderRequest(Long productId, String email, Long quantity) {
        this.productId = productId;
        this.email = email;
        this.quantity = quantity;
    }

    public Order toEntity(User user, Product product, Long totalPrice) {
        return Order.builder()
                .user(user)
                .product(product)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }
}
