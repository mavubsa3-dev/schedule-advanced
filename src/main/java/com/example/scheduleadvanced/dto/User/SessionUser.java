package com.example.scheduleadvanced.dto.User;

import lombok.Getter;

@Getter
public class SessionUser {
    private final Long userId;

    public SessionUser(Long userId) {
        this.userId = userId;
    }
}
