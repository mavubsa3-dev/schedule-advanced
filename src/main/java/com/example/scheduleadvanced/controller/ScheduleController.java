package com.example.scheduleadvanced.controller;

import com.example.scheduleadvanced.dto.Schedule.*;
import com.example.scheduleadvanced.dto.User.SessionUser;
import com.example.scheduleadvanced.service.ScheduleService;
import com.example.scheduleadvanced.util.LoginAuthorizationUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
    public ResponseEntity<CreateScheduleResponse> save(@Valid @RequestBody CreateScheduleRequest request, HttpSession session){
        LoginAuthorizationUtil.isLoginUser(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request, session));

    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponse>> getAll(HttpSession session){
        LoginAuthorizationUtil.isLoginUser(session);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetScheduleResponse> getOne(@PathVariable Long scheduleId, HttpSession session){
        LoginAuthorizationUtil.isLoginUser(session);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateSchedule(@PathVariable Long scheduleId,@Valid @RequestBody UpdateScheduleRequest request, HttpSession session){
        LoginAuthorizationUtil.isLoginUser(session);
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId, HttpSession session){
        LoginAuthorizationUtil.isLoginUser(session);
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
