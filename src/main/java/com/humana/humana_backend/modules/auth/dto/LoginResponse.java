package com.humana.humana_backend.auth.dto;

import com.humana.humana_backend.user_management.model.User;
import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private String refreshToken;

    private User userDetails;

    public LoginResponse(
            String accessToken,
            String refreshToken,
            User user
    ){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.userDetails = user;
    }
}
