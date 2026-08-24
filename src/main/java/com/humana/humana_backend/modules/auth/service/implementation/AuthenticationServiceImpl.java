package com.humana.humana_backend.modules.auth.service.implementation;

import com.humana.humana_backend.common.exception.IncorrectPasswordException;
import com.humana.humana_backend.common.exception.UserAccountLockedException;
import com.humana.humana_backend.common.exception.UserNotFoundException;
import com.humana.humana_backend.modules.auth.dto.LoginDto;
import com.humana.humana_backend.modules.auth.dto.LoginResponse;
import com.humana.humana_backend.modules.auth.service.AuthenticationService;
import com.humana.humana_backend.modules.user_management.model.Role;
import com.humana.humana_backend.modules.user_management.model.User;
import com.humana.humana_backend.modules.user_management.repository.UserRepository;
import com.humana.humana_backend.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginDto loginDto) {
        User user = userRepository
                .findByUsername(loginDto.getUsername()).orElseThrow(()-> new UserNotFoundException(String.format("User with username: %s is not found", loginDto.getUsername())));

        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            throw new IncorrectPasswordException("Incorrect password or username");
        }
        if(user.isLocked()){
            throw new UserAccountLockedException(
                    String.format("User account with username: %s is locked, please activate your account and try again", loginDto.getUsername())
            );
        }
        List<String> roles = user.getRoles().stream().map(role -> role.getRoleName().toString())
                .toList();
        String accessToken = jwtUtils.generateToken(user.getUsername(), roles);
        String refreshToken = jwtUtils.generateRefreshToken(user.getUsername(), roles);

        return new LoginResponse(
                accessToken,
                refreshToken,
                user
        );

    }

    @Override
    public void logout() {

    }
}
