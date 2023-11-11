package com.example.productmanagement.order.presentation;

import com.example.productmanagement.order.application.OrderService;
import com.example.productmanagement.order.dto.request.CreateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderViewController {

    private final OrderService orderService;

    @GetMapping("/new/{productId}")
    public String createOrderPage(@PathVariable Long productId, Model model) {

        model.addAttribute("productId", productId);

        return "order/order-form";
    }

    @PostMapping
    public String createOrder(CreateOrderRequest createOrderRequest) {

        String email = orderService.createOrder(createOrderRequest).getEmail();

        return "redirect:/orders/" + email;
    }

    @GetMapping("/{email}")
    public String getOrdersByUser(@PathVariable String email, Model model) {

        model.addAttribute("email", email);
        model.addAttribute("orders", orderService.getOrdersByUser(email));

        return "order/order-list";
    }

    @PostMapping("/{email}/{orderId}")
    public String deleteOrder(@PathVariable String email, @PathVariable Long orderId) {

        orderService.deleteOrder(orderId);

        return "redirect:/orders/" + email;
    }
}
