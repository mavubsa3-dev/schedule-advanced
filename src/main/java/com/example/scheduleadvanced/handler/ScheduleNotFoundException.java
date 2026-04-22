package com.example.scheduleadvanced.handler;


import org.springframework.http.HttpStatus;

public class ScheduleNotFoundException extends ScheduleException{
    public ScheduleNotFoundException(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
