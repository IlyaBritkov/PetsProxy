package com.leverx.pets.exception;

import org.springframework.http.HttpStatus;

public class ExchangeException extends RestException {

    public ExchangeException(String message) {
        super(message);
    }

    public ExchangeException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
