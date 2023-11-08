package com.example.productmanagement.order.dto.request;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.product.domain.Product;
import com.example.productmanagement.user.domain.User;
import lombok.Getter;

@Getter
public class CreateOrderRequest {

    private Long productId;
    private String email;
    private Long quantity;

    public Order toEntity(User user, Product product, Long totalPrice) {
        return Order.builder()
                .user(user)
                .product(product)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }
}
