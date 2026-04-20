package com.example.scheduleadvanced.controller;

import com.example.scheduleadvanced.dto.Schedule.UpdateScheduleRequest;
import com.example.scheduleadvanced.dto.User.CreateUserRequest;
import com.example.scheduleadvanced.dto.User.CreateUserResponse;
import com.example.scheduleadvanced.entity.User;
import com.example.scheduleadvanced.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> save(@RequestBody CreateUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @GetMapping("/users")
    public ResponseEntity
}
