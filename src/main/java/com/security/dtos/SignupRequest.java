package com.security.dtos;

import com.security.enums.UserRole;
import lombok.Data;

@Data
public class SignupRequest {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
}
