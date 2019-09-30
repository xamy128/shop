package com.sample.shop.common.service;

/**
 * Type of exceptions that can occur in both service(core) and data layer.
 * Different actions and messages can be applied depending on the type.
 *
 * @author Ammarah Shakeel
 */
public enum  ExceptionType {
    DUPLICATE_KEY,
    NO_ENTITY,
    VALIDATION,
    USER_UNKNOWN,
    NO_ACCESS,
    UNKNOWN
}
