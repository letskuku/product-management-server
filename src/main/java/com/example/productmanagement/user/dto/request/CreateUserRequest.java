package com.example.productmanagement.user.dto.request;

import com.example.productmanagement.user.domain.User;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    private String name;
    private String email;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
