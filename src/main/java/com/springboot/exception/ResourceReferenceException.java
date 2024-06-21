package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceReferenceException extends RuntimeException {
    public ResourceReferenceException(String message) {
        super(message);
    }
}
