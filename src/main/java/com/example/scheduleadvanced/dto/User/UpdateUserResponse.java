package com.example.scheduleadvanced.dto.User;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateUserResponse {
    private final String name;
    private final String email;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;

    public UpdateUserResponse(String name, String email, LocalDateTime createAt, LocalDateTime updateAt) {
        this.name = name;
        this.email = email;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
