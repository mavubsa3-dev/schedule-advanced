package com.example.scheduleadvanced.service;

import com.example.scheduleadvanced.dto.User.*;
import com.example.scheduleadvanced.entity.User;
import com.example.scheduleadvanced.handler.UserNotFoundExcpetion;
import com.example.scheduleadvanced.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(request.getPassword(), request.getName(), request.getEmail());
        User savedUser = userRepository.save(user);
        return new CreateUserResponse(
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreateAt(),
                savedUser.getUpdateAt());
    }

    @Transactional(readOnly = true)
    public User login(UserLoginRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        if(user == null){
            throw new IllegalStateException("일치하는 이메일이 없습니다.");
        }
        if(!request.getPassword().equals(user.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        return user;
    }

    @Transactional
    public List<GetUserResponse> getAll() {
        List<User> userList = userRepository.findAll();
        List<GetUserResponse> dtos = new ArrayList<>();
        for(User user : userList){
            GetUserResponse dto = new GetUserResponse(
                    user.getName(),
                    user.getEmail(),
                    user.getCreateAt(),
                    user.getUpdateAt());
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public GetUserResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundExcpetion("존재하지 않는 유저입니다.")
        );
        return new GetUserResponse(
                user.getName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdateAt());
    }

    @Transactional
    public UpdateUserResponse update(Long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundExcpetion("존재하지 않는 유저입니다.")
        );
        user.update(request.getName(), request.getEmail());

        return new UpdateUserResponse(
                user.getName(),
                user.getEmail(),
                user.getCreateAt(),
                user.getUpdateAt());
    }

    @Transactional
    public void delete(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundExcpetion("존재하지 않는 유저입니다.")
        );
        userRepository.delete(user);
    }
}
