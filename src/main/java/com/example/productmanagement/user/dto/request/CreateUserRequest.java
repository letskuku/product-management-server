package com.example.productmanagement.user.dto.request;

import com.example.productmanagement.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    private final String name;
    private final String email;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }

    @Builder
    public CreateUserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
