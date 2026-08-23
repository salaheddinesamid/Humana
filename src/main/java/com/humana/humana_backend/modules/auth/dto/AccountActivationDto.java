package com.humana.humana_backend.modules.auth.dto;

import lombok.Data;

@Data
public class AccountActivationDto {
    private String rawPassword;
    private String confirmedPassword;
}
