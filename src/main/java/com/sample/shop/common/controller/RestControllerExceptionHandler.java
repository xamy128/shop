package com.sample.shop.common.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Handles controller level exceptions and return @Response accordingly.
 */
@Component
@ControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleErrors(Exception e) {
        Response<Object> response = new RestResponse<>().exception(e);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
