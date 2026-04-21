package com.example.scheduleadvanced.controller;

import com.example.scheduleadvanced.dto.Schedule.*;
import com.example.scheduleadvanced.dto.User.SessionUser;
import com.example.scheduleadvanced.service.ScheduleService;
import com.example.scheduleadvanced.util.LoginAuthorizationUtil;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<CreateScheduleResponse> save(@RequestBody CreateScheduleRequest request, HttpSession session){
        SessionUser loginUser = LoginAuthorizationUtil.isLoginUser(session);
        if(loginUser != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
        }
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId){
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
