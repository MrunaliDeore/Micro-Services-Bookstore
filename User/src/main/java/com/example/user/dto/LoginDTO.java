package com.example.user.dto;

import lombok.Data;

@Data
public class LoginDTO {
    public String loginid;
    public String password;
    private String email;
}
