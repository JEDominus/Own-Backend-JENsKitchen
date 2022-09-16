package com.jens.kitchen.exceptions;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    private List<ApiError> errors;
    public BadRequestException(String message, List<ApiError> errors){
        super(message);
        this.errors = errors;
    }
}
