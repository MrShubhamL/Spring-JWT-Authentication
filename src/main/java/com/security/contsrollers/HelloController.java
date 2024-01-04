package com.security.contsrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class HelloController {

    @GetMapping("/home")
    public String authApiTest(){
        return "You are successfully login and accessing authorized page.";
    }
}
