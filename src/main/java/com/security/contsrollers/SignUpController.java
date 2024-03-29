package com.security.contsrollers;

import com.security.dtos.SignupRequest;
import com.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class SignUpController {
    private final AuthService authService;
    @Autowired
    public SignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUpCustomer(@RequestBody SignupRequest signupRequest){
        boolean isUserCreated = authService.createCustomer(signupRequest);
        if(isUserCreated){
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully.");
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user!");
        }
    }
}
