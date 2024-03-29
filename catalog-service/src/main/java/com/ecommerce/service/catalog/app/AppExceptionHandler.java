package com.ecommerce.service.catalog.app;

import com.ecommerce.service.catalog.exception.AppItemAlreadyExistsException;
import com.ecommerce.service.catalog.model.common.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppItemAlreadyExistsException.class)
    public final Mono<ResponseEntity<BaseResponse<?>>> handleAlreadyExistsException(Exception ex, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.CONFLICT));
    }

    @Override
    public Mono<ResponseEntity<Object>> handleWebExchangeBindException(WebExchangeBindException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getFieldError().getDefaultMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Override
    public Mono<ResponseEntity<Object>> handleMethodNotAllowedException(MethodNotAllowedException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY));
    }

    @Override
    public Mono<ResponseEntity<Object>> handleResponseStatusException(ResponseStatusException ex, HttpHeaders headers, HttpStatusCode status, ServerWebExchange exchange) {
        handleExceptionInternal(ex, null, headers, status, exchange);
        return Mono.just(new ResponseEntity<>(BaseResponse.fail(ex.getMessage()), status));
    }
}
