package com.humana.humana_backend.modules.auth.controller;

import com.humana.humana_backend.modules.auth.dto.LoginDto;
import com.humana.humana_backend.modules.auth.service.implementation.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto loginDto){
        return ResponseEntity.status(200)
                .body(authenticationService.login(loginDto));
    }
}
