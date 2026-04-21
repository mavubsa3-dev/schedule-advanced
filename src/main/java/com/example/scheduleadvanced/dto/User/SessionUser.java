package com.example.scheduleadvanced.dto.User;

import lombok.Getter;

@Getter
public class SessionUser {
    private final String email;
    private final String password;

    public SessionUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
