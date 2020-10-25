package com.rga.swagger.swaggerexample.exception;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
public class ValidationException extends Exception {

    private List<FieldError> errors;
    private String id;

    public ValidationException(String id, List<FieldError> list) {
        this.id = id;
        this.errors = list;
    }

    public ValidationException(String id, List<FieldError> list, String message) {
        super(message);
        this.id = id;
        this.errors = list;
    }
}
