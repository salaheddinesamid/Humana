package com.humana.humana_backend.common.exception;

import com.humana.humana_backend.common.dto.ErrorResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException userNotFoundException, HttpServletRequest request){

        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                "UNAUTHORIZED",
                userNotFoundException.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(
                HttpStatus.UNAUTHORIZED
        ).body(response);
    }

    @ExceptionHandler(OrganizationAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleOrganizationAlreadyExists(
            OrganizationAlreadyExistsException ex,
            HttpServletRequest request
    ){
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "BAD REQUEST",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(
                        HttpStatus.BAD_REQUEST
                ).body(response);
    }

    @ExceptionHandler(UnmatchedPasswordsException.class)
    public ResponseEntity<ErrorResponse> handleUnmatchedPasswords(
            UnmatchedPasswordsException ex,
            HttpServletRequest request
    ){
        ErrorResponse response = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "BAD REQUEST",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(
                        HttpStatus.BAD_REQUEST
                ).body(response);
    }
}
