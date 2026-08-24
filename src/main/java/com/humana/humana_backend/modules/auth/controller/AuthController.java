package com.humana.humana_backend.modules.auth.controller;

import com.humana.humana_backend.modules.auth.dto.AccountActivationDto;
import com.humana.humana_backend.modules.auth.dto.LoginDto;
import com.humana.humana_backend.modules.auth.service.implementation.AuthenticationServiceImpl;
import com.humana.humana_backend.modules.user_management.service.implementation.UserActivationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationServiceImpl authenticationService;
    private final UserActivationServiceImpl userActivationService;

    @Autowired
    public AuthController(AuthenticationServiceImpl authenticationService, UserActivationServiceImpl adminActivationService) {
        this.authenticationService = authenticationService;
        this.userActivationService = adminActivationService;
    }

    @PostMapping("")
    public ResponseEntity<?> authenticate(@RequestBody LoginDto loginDto){
        return ResponseEntity.status(200)
                .body(authenticationService.login(loginDto));
    }

    @PutMapping("activate")
    public ResponseEntity<?> activateUser(
            @RequestParam String token, @RequestBody AccountActivationDto dto
            ){
        userActivationService.activate(dto, token);

        return ResponseEntity.status(HttpStatus.OK)
                .body("This account has been activated successfully");
    }
}
