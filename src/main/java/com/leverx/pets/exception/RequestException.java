package com.leverx.pets.exception;

import org.springframework.http.HttpStatus;

public class RequestException extends RestException {

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
