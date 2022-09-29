package com.example.user.entity;

import com.example.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private int userid;
    private String firstname;
    private String lastname;
    private String email;
    private  String address;
    @Column(name = "login_id", nullable = false)
    private String loginid;

    private String username;
    private String password;
    private byte isadmin;

    public User(UserDTO userDTO) {
        this.firstname=userDTO.getFirstname();
        this.lastname = userDTO.getLastname();
        this.email = userDTO.getEmail();
        this.address = userDTO.getAddress();
        this.loginid = userDTO.getLoginid();
        this.password = userDTO.getPassword();
        this.isadmin = userDTO.getIsadmin();
    }
}
