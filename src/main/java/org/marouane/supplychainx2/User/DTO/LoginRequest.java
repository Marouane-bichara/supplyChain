package org.marouane.supplychainx2.User.DTO;


import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}

