package com.example.productmanagement.product.repository;

import com.example.productmanagement.product.domain.Category;
import com.example.productmanagement.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByIdAndIsActivated(Long id, Boolean isActivated);

    List<Product> findAllByCategoryAndIsActivated(Category category, Boolean isActivated);

    List<Product> findAllByIsActivated(Boolean isActivated);
}
