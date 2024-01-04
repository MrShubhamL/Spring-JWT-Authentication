package com.security.dtos;

import lombok.Data;

@Data
public class LoginResponse {
    private String jwtToken;
    public LoginResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
