package com.example.scheduleadvanced.dto.Schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequest {

    @NotBlank(message = "일정 제목을 입력하세요")
    @Size(min = 4)
    private String title;

    @NotBlank(message = "내용을 입력하세요")
    @Size(max = 1500)
    private String content;

}
