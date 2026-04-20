package com.example.scheduleadvanced.repository;

import com.example.scheduleadvanced.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
