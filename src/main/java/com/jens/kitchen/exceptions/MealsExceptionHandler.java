package com.jens.kitchen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class MealsExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestErrors> handleBadRequestException(BadRequestException exception){
        BadRequestErrors errorsResponse = BadRequestErrors.builder().errors(exception.getErrors()).build();
        return new ResponseEntity<>(errorsResponse, HttpStatus.BAD_REQUEST);
    }
}
