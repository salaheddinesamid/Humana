package com.humana.humana_backend.common.exception;

public class OrganizationAlreadyExistsException extends RuntimeException{

    public OrganizationAlreadyExistsException(String message){
        super(message);
    }
}
