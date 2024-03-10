package com.ecommerce.service.catalog.model.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
final public class BaseResponse<T> {
    private Boolean status;
    private String message;
    private T data;

    private static final Boolean SUCCESS = true;
    private static final Boolean FAILED = false;

    static class BaseResponseMessage {
        static final String OK = "Successful";
        static final String FAIL = "Unsuccessful";
    }

    public static<T> BaseResponse<T> ok(String message, T data) {
        return new BaseResponse<T>(SUCCESS, message, data);
    }

    public static<T> BaseResponse<T> ok(T data) {
        return ok(BaseResponseMessage.OK,data);
    }

    public static<T> BaseResponse<T> ok() {
        return ok(null);
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse(String message, T data) {
        return ResponseEntity.ok(ok(message, data));
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse(T data) {
        return okResponse(BaseResponseMessage.OK, data);
    }

    public static<T> ResponseEntity<BaseResponse<T>> okResponse() {
        return okResponse(null);
    }

    public static<T> BaseResponse<T> fail(String message) {
        return new BaseResponse<T>(FAILED, message, null);
    }

    public static<T> ResponseEntity<BaseResponse<T>> failResponse(String message) {
        return new ResponseEntity<>(fail(message), HttpStatus.BAD_REQUEST);
    }

    public static<T> ResponseEntity<BaseResponse<T>> failResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(fail(message), status);
    }

    public static<T> ResponseEntity<BaseResponse<T>> failResponse(HttpStatus status) {
        return new ResponseEntity<>(fail(BaseResponseMessage.FAIL), status);
    }
}