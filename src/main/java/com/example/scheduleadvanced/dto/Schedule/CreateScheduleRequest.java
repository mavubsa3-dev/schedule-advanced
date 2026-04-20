package com.example.scheduleadvanced.dto.Schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {
    private Long userId;
    private String title;
    private String content;

}
