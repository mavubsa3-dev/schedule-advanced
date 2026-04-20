package com.example.scheduleadvanced.dto.Schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest {
    private Long userId;
    private String title;
    private String content;
}
