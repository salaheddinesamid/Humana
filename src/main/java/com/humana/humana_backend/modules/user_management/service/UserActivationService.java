package com.humana.humana_backend.modules.user_management.service;

import com.humana.humana_backend.modules.auth.dto.AccountActivationDto;

public interface UserActivationService {

    void activate(AccountActivationDto dto, String token);
}
