package com.example.scheduleadvanced.dto.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserLoginRequest {

    @NotBlank(message = "이메일을 입력하세요")
    @Email
    private String email;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Size(min = 4, max = 20)
    private String password;
}
