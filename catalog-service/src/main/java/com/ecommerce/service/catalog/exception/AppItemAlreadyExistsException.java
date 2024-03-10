package com.ecommerce.service.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AppItemAlreadyExistsException extends RuntimeException {
    public AppItemAlreadyExistsException(String message) {
        super(message);
    }
}
