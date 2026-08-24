package com.humana.humana_backend.common.exception;

public class UserAccountLockedException extends RuntimeException{

    public UserAccountLockedException(String message){
        super(message);
    }
}
