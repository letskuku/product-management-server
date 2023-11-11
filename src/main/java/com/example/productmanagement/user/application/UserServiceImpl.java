package com.example.productmanagement.user.application;

import com.example.productmanagement.user.dto.request.CreateUserRequest;
import com.example.productmanagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(CreateUserRequest createUserRequest) {
        userRepository.save(createUserRequest.toEntity());
    }
}
