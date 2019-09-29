package com.sample.shop.common.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Custom HTTP response with status, data and message
 *
 * @param <T>  Type of data passed
 *
 * @author Ammarah.Shakeel
 */
@Getter @Setter
public class Response<T> {
    private HttpStatus status;
    private T data;
    private Message message;

     Response(HttpStatus status, T data, Message message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

     Response(HttpStatus status, Message message) {
        this.status = status;
        this.message = message;
    }
}
