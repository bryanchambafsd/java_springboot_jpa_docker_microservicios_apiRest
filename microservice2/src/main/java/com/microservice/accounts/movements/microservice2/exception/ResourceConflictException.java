package com.microservice.accounts.movements.microservice2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceConflictException extends RuntimeException{

    public ResourceConflictException(String message){
        super(message);
    }

}
