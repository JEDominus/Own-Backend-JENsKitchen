package com.jens.kitchen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MealsExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrors> handleBadRequestException(BadRequestException exception){
        ApiErrors errorsResponse = ApiErrors.builder().errors(exception.getErrors()).build();
        return new ResponseEntity<>(errorsResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> handleNotFoundException(NotFoundException exception){
        ApiError errorResponse = ApiError.builder().field(exception.getError().getField()).description(exception.getError().getDescription()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
