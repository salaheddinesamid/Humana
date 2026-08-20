package com.humana.humana_backend.modules.auth.service;

import com.humana.humana_backend.modules.auth.dto.LoginDto;
import com.humana.humana_backend.modules.auth.dto.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginDto loginDto);

    void logout();
}
