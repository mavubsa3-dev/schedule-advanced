package com.example.scheduleadvanced.service;

import com.example.scheduleadvanced.dto.Schedule.*;
import com.example.scheduleadvanced.entity.Schedule;
import com.example.scheduleadvanced.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<GetScheduleResponse> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> dtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getName(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getCreativeAt(),
                    schedule.getUpdateAt());
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional
    public GetScheduleResponse getOne(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        return new GetScheduleResponse(
                schedule.getName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreativeAt(),
                schedule.getUpdateAt());
    }

    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        schedule.update(request.getName(), request.getTitle(), request.getContent());
        return new UpdateScheduleResponse(
                schedule.getName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreativeAt(),
                schedule.getUpdateAt());
    }

    @Transactional
    public void delete(Long scheduleId){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        scheduleRepository.delete(schedule);
    }
}
