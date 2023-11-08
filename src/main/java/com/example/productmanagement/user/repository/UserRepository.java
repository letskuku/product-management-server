package com.example.productmanagement.user.repository;

import com.example.productmanagement.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndIsActivated(String email, Boolean isActivated);
}
