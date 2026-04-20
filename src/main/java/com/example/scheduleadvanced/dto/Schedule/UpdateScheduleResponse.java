package com.example.scheduleadvanced.dto.Schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateScheduleResponse {
    private final String name;
    private final String title;
    private final String content;
    private final LocalDateTime creativeAt;
    private final LocalDateTime updateAt;

    public UpdateScheduleResponse(String name, String title, String content, LocalDateTime creativeAt, LocalDateTime updateAt) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.creativeAt = creativeAt;
        this.updateAt = updateAt;
    }
}
