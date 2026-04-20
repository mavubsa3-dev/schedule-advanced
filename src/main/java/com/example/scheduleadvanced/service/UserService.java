package com.example.scheduleadvanced.service;

import com.example.scheduleadvanced.dto.User.CreateUserRequest;
import com.example.scheduleadvanced.dto.User.CreateUserResponse;
import com.example.scheduleadvanced.entity.User;
import com.example.scheduleadvanced.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(request.getName(), request.getEmail());
        return new CreateUserResponse(
                user.getName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdateAt());
    }
}
