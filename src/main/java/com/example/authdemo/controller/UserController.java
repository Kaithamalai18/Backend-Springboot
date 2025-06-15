package com.example.authdemo.controller;

import com.example.authdemo.service.RegisterRequest;
import com.example.authdemo.service.LoginRequest;
import com.example.authdemo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody @Valid LoginRequest request) {
        return userService.loginUser(request);
    }

    @GetMapping("/me")
    public String getCurrentUser(HttpServletRequest request) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello, " + email + "! This is a protected endpoint.";
    }


}
