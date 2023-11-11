package com.example.productmanagement.order.repository;

import com.example.productmanagement.order.domain.Order;
import com.example.productmanagement.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdAndIsActivated(Long id, Boolean isActivated);

    List<Order> findAllByUser(User user);
}
