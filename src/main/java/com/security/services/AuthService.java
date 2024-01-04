package com.security.services;

import com.security.dtos.SignupRequest;

public interface AuthService {
    boolean createCustomer(SignupRequest signUpDto);
}
