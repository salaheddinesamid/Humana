package com.humana.humana_backend.auth.service.implementation;

import com.humana.humana_backend.auth.dto.LoginDto;
import com.humana.humana_backend.auth.dto.LoginResponse;
import com.humana.humana_backend.auth.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {


    @Override
    public LoginResponse login(LoginDto loginDto) {
        return null;
    }

    @Override
    public void logout() {

    }
}
