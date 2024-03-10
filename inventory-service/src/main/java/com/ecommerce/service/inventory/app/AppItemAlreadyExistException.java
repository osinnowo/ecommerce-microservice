package com.ecommerce.service.inventory.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AppItemAlreadyExistException extends RuntimeException {
    public AppItemAlreadyExistException(String message) {
        super(message);
    }
}
