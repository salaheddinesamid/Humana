package com.humana.humana_backend.common.exception;

public class IncorrectPasswordException extends RuntimeException{

    public IncorrectPasswordException(String message){
        super(message);
    }
}
