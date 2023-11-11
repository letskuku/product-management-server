package com.example.productmanagement.user.presentation;

import com.example.productmanagement.user.application.UserService;
import com.example.productmanagement.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserViewController {

    private final UserService userService;

    @GetMapping("/new")
    public String createUserPage() {
        return "user/user-form";
    }

    @PostMapping
    public String createUser(CreateUserRequest createUserRequest) {

        userService.createUser(createUserRequest);

        return "redirect:/products";
    }
}
