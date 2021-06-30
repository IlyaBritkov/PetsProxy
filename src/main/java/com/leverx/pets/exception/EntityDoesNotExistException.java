package com.leverx.pets.exception;

import org.springframework.http.HttpStatus;

public class EntityDoesNotExistException extends RestException {

    public EntityDoesNotExistException(String message) {
        super(message);
    }

    public EntityDoesNotExistException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
