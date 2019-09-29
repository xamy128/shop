package com.sample.shop.common.service;

import lombok.Getter;
import lombok.Setter;

/**
 * Class to hold exceptions from Core Service Layer.
 *
 * @author Ammarah Shakeel
 */
@Getter @Setter
public class CoreException extends RuntimeException {
    private ExceptionType exceptionType;
    private String message = "";

    public CoreException(ExceptionType exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }

     CoreException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
