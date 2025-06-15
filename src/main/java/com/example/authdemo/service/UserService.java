package com.example.authdemo.service;

import com.example.authdemo.model.User;
import com.example.authdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Register
    public String registerUser(RegisterRequest request) {
        // check if email exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        // hash password
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // create user
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(hashedPassword);

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String loginUser(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid email");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🪪 Generate JWT Token
        String token = jwtUtil.generateToken(user.getEmail());

        return "Login successful. Your token: " + token;
    }

}
