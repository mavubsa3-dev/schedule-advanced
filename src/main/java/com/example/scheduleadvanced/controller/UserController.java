package com.example.scheduleadvanced.controller;

import com.example.scheduleadvanced.dto.Schedule.UpdateScheduleRequest;
import com.example.scheduleadvanced.dto.User.*;
import com.example.scheduleadvanced.entity.User;
import com.example.scheduleadvanced.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<CreateUserResponse> save(@Valid @RequestBody CreateUserRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @PostMapping("/users/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginRequest request, HttpSession session){
        try{
            User user = userService.login(request);

            SessionUser sessionUser = new SessionUser(user.getId());
            session.setAttribute("loginUser", sessionUser);

            return ResponseEntity.status(HttpStatus.OK).body("로그인 성공!");
        }catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("이메일이나 비밀번호가 옳지 않습니다.");
        }
    }

    @PostMapping("/users/logout")
    public ResponseEntity<String> logout(@SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser, HttpSession session){
        if(sessionUser == null){
            return ResponseEntity.badRequest().body("로그인을 먼저 하세요");
        }

        session.invalidate();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("로그아웃 되었습니다.");
    }

    @GetMapping("/users")
    public ResponseEntity<List<GetUserResponse>> AllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<GetUserResponse> getOne(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOne(userId));
    }

    @PatchMapping("/users/{userId}")
    public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Long userId,@Valid @RequestBody UpdateUserRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
