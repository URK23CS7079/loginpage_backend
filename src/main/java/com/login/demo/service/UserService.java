package com.login.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.login.demo.model.LoginRequest;
import com.login.demo.model.LoginResponse;
import com.login.demo.model.User;
import com.login.demo.repo.UserRepository;


@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public ResponseEntity<LoginResponse> validateLogin(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(new LoginResponse("Login successful"));
        } else {
            return ResponseEntity.status(401)
                .body(new LoginResponse("Invalid username or password"));
        }
    }
}
