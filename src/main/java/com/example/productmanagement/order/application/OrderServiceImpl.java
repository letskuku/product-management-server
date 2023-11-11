package com.example.productmanagement.order.application;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.order.dto.request.CreateOrderRequest;
import com.example.productmanagement.order.dto.response.CreateOrderResponse;
import com.example.productmanagement.order.dto.response.OrderResponse;
import com.example.productmanagement.order.exception.OrderErrorCode;
import com.example.productmanagement.order.exception.OrderException;
import com.example.productmanagement.order.repository.OrderRepository;
import com.example.productmanagement.product.domain.Product;
import com.example.productmanagement.product.exception.ProductErrorCode;
import com.example.productmanagement.product.exception.ProductException;
import com.example.productmanagement.product.repository.ProductRepository;
import com.example.productmanagement.user.domain.User;
import com.example.productmanagement.user.exception.UserErrorCode;
import com.example.productmanagement.user.exception.UserException;
import com.example.productmanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {

        User user = userRepository.findByEmailAndIsActivated(createOrderRequest.getEmail(), true)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND, createOrderRequest.getEmail()));

        Product product = productRepository.findByIdAndIsActivated(createOrderRequest.getProductId(), true)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND, createOrderRequest.getProductId()));

        product.reduceStock(createOrderRequest.getQuantity());

        Long totalPrice = createOrderRequest.getQuantity() * product.getPrice();

        Order order = orderRepository.save(createOrderRequest.toEntity(user, product, totalPrice));

        return CreateOrderResponse.fromEntity(order);
    }

    @Override
    public List<OrderResponse> getOrdersByUser(String email) {

        User user = userRepository.findByEmailAndIsActivated(email, true)
                .orElseThrow(() -> new UserException(UserErrorCode.USER_NOT_FOUND, email));

        List<OrderResponse> orderResponses = orderRepository.findAllByUser(user)
                .stream()
                .map(OrderResponse::fromEntity)
                .toList();

        return orderResponses;
    }

    @Override
    @Transactional
    public void deleteOrder(Long orderId) {

        Order order = orderRepository.findByIdAndIsActivated(orderId, true)
                .orElseThrow(() -> new OrderException(OrderErrorCode.ORDER_NOT_FOUND, orderId));

        order.updateIsActivatedFalse();
        order.getProduct().increaseStock(order.getQuantity());
    }
}
