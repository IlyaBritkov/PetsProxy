package com.leverx.pets.exception_handling;

import com.leverx.pets.dto.response.ExceptionResponseDTO;
import com.leverx.pets.exception.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(RestException ex) {
        log.error("Exception was thrown: {}, httpStatus={}", ex.getMessage(), ex.getHttpStatus());

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(ex.getMessage());

        return new ResponseEntity<>(exceptionResponseDTO, ex.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex
                .getBindingResult()
                .getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });

        return errors;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(Exception ex) {
        log.error("Exception was thrown: " + ex.getMessage());

        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO("Sorry!Try again later" + ex.getMessage());

        return new ResponseEntity<>(exceptionResponseDTO, NOT_FOUND);
    }
}
