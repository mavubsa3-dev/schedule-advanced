package com.example.scheduleadvanced.controller;

import com.example.scheduleadvanced.dto.Schedule.CreateScheduleRequest;
import com.example.scheduleadvanced.dto.Schedule.CreateScheduleResponse;
import com.example.scheduleadvanced.dto.Schedule.GetScheduleResponse;
import com.example.scheduleadvanced.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> save(@RequestBody CreateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(scheduleId));
    }

    @PutMapping("/scheudles/{scheduleId}")
}
