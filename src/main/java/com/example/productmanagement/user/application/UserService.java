package com.example.productmanagement.user.application;

import com.example.productmanagement.user.dto.request.CreateUserRequest;

public interface UserService {

    void createUser(CreateUserRequest createUserRequest);
}
