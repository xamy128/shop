package com.sample.shop.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    private RestResponse restResponse;

    @Autowired
    public RestControllerExceptionHandler(RestResponse restResponse) {
        this.restResponse = restResponse;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleErrors(Exception e) {
        Response response = restResponse.exception(e);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
