package com.example.scheduleadvanced.util;

import com.example.scheduleadvanced.dto.User.SessionUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LoginAuthorizationUtil {

    private LoginAuthorizationUtil(){
        throw new IllegalStateException("Utility Class");
    }

    public static SessionUser isLoginUser(HttpSession session){
        SessionUser loginUser = (SessionUser) session.getAttribute("loginUser");
        if(loginUser == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");
        }
        return loginUser;
    }
}
