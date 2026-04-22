package com.example.scheduleadvanced.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ScheduleException extends RuntimeException{

    private HttpStatus status;

    public ScheduleException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }

}
