package com.example.scheduleadvanced.dto.Schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponse {
    private final Long userId;
    private final String title;
    private final String content;
    private final LocalDateTime creativeAt;
    private final LocalDateTime updateAt;

    public GetScheduleResponse(Long userId, String title, String content, LocalDateTime creativeAt, LocalDateTime updateAt) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.creativeAt = creativeAt;
        this.updateAt = updateAt;
    }
}
