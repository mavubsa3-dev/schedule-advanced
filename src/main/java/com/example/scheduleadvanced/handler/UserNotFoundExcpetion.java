package com.example.scheduleadvanced.handler;

import org.springframework.http.HttpStatus;

public class UserNotFoundExcpetion extends UserException{
    public UserNotFoundExcpetion(String message){
        super(HttpStatus.NOT_FOUND, message);
    }
}
