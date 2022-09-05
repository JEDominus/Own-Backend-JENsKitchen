package com.jens.kitchen.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }

}
