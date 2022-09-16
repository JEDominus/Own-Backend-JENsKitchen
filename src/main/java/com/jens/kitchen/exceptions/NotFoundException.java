package com.jens.kitchen.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    private ApiError error;
    public NotFoundException(String message, ApiError error){
        super(message);
        this.error = error;
    }
}
