package com.rga.swagger.swaggerexample.controller;

import com.rga.swagger.swaggerexample.exception.ValidationException;
import com.rga.swagger.swaggerexample.model.RGABaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class, IOException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        RGABaseResponse rgaBaseResponse = new RGABaseResponse();
        rgaBaseResponse.setStatus("Service unavailable");
        rgaBaseResponse.setResponseCode(503);
        return new ResponseEntity<>(rgaBaseResponse, new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<Object> handleValidationException(final ValidationException validationException) {
        logger.error(validationException.getMessage(), validationException);
        Iterator<FieldError> iterator = validationException.getErrors().iterator();
        List<String> validationErrorList = new ArrayList<>();
        while(iterator.hasNext()) {
            FieldError fieldError = iterator.next();
            validationErrorList.add(fieldError.getDefaultMessage());
        }
        RGABaseResponse rgaBaseResponse = new RGABaseResponse("Invalid request. Please enter the valid data.",
                HttpStatus.BAD_REQUEST.getReasonPhrase(),400, validationErrorList);
        return new ResponseEntity<>(rgaBaseResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
