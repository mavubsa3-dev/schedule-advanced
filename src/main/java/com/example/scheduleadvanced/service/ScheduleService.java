package com.example.scheduleadvanced.service;

import com.example.scheduleadvanced.dto.Schedule.CreateScheduleRequest;
import com.example.scheduleadvanced.dto.Schedule.CreateScheduleResponse;
import com.example.scheduleadvanced.entity.Schedule;
import com.example.scheduleadvanced.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getName(),
                request.getTitle(),
                request.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponse(
                savedSchedule.getName(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getCreativeAt(),
                savedSchedule.getUpdateAt());
    }
}
