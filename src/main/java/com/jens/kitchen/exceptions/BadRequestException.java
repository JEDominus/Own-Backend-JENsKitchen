package com.jens.kitchen.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BadRequestException extends RuntimeException{
    private List<BadRequestError> errors;
    public BadRequestException(String message, List<BadRequestError> errors){
        super(message);
        this.errors = errors;
    }
}
