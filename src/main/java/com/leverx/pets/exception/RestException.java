package com.leverx.pets.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestException extends RuntimeException {

    /**
     * HttpStatus.NOT_FOUND - status by default.
     * To change it use constructor which accepts status or set it by setter
     **/
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public RestException(String message) {
        super(message);
    }

    public RestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
