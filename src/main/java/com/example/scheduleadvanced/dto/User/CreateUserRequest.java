package com.example.scheduleadvanced.dto.User;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    private String name;
    private String password;
    private String email;
}
