package com.humana.humana_backend.auth.service;

import com.humana.humana_backend.auth.dto.LoginDto;
import com.humana.humana_backend.auth.dto.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginDto loginDto);

    void logout();
}
