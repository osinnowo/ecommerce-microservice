package com.ecommerce.service.inventory.app;

import com.ecommerce.service.inventory.model.common.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//.UnexpectedTypeException
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppItemAlreadyExistException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleAlreadyExistException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.CONFLICT));
    }

    @Override
    protected Mono<ResponseEntity<Object>> handleResponseStatusException(ResponseStatusException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), status));
    }
}
