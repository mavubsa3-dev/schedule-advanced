package com.example.scheduleadvanced.dto.Schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {
    private String name;
    private String title;
    private String content;

}
