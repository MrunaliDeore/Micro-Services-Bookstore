package com.example.user.dto;

import com.example.user.entity.Login;
import com.example.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserStatus {
    private User user;
    private String status;
    private String message;




}
