package com.sample.shop.common.controller;

import com.sample.shop.common.TemplateUtils;
import com.sample.shop.common.service.CoreException;
import com.sample.shop.common.service.ExceptionType;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * generate custom response for each request to the controller
 * @param <T> data type
 *
 * @author Ammarah Shakeel
 */
@Component
@NoArgsConstructor
public class RestResponse<T> {
    private TemplateUtils tempUtils;

    @Autowired
    public RestResponse(TemplateUtils templateUtils) {
        this.tempUtils = templateUtils;
    }

    public Response<T> createSuccessful(T data) {
        return new Response<>(
                HttpStatus.CREATED,
                data,
                new Message(
                        tempUtils.message("message.create_successful.title"),
                        tempUtils.message("message.create_successful.msg"),
                        MessageType.SUCCESS
                )
        );
    }

    public Response<T> updateSuccessful(T data) {
        return new Response<>(
                HttpStatus.OK,
                data,
                new Message(
                        tempUtils.message("message.update_successful.title"),
                        tempUtils.message("message.update_successful.msg"),
                        MessageType.SUCCESS
                )
        );
    }

     Response<T> deleteSuccessful() {
        return new Response<>(
                HttpStatus.OK,
                new Message(
                        tempUtils.message("message.delete_successful.title"),
                        tempUtils.message("message.delete_successful.msg"),
                        MessageType.SUCCESS
                )
        );
    }

    private Response<T> nullPointerException() {
        return new Response<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Message(
                        tempUtils.message("error.null_pointer_exception.title"),
                        tempUtils.message("error.null_pointer_exception.msg"),
                        MessageType.DANGER
                )
        );
    }

    private Response<T> duplicateKey(String message) {
        String errorMessage = tempUtils.message("error.duplicate_key.msg");

        if(message != null && !message.equals(""))
            errorMessage = message;
        return new Response<>(
                HttpStatus.CONFLICT,
                new Message(
                        tempUtils.message("error.duplicate_key.title"),
                        errorMessage,
                        MessageType.DANGER
                )
        );
    }

    private Response<T> noEntity(String message) {
        String errorMessage = message;

        if(message == null || message.equals(""))
            errorMessage = tempUtils.message("error.no_entity.msg");
        return new Response<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Message(
                        tempUtils.message("error.no_entity.title"),
                        errorMessage,
                        MessageType.DANGER
                )
        );
    }

    private Response<T> unknownError(String message) {
        String errorMessage = message;

        if(message == null || message.equals(""))
            errorMessage = tempUtils.message("error.unknown_error.msg");

        return new Response<>(
                HttpStatus.INTERNAL_SERVER_ERROR,
                new Message(
                        tempUtils.message("error.unknown_error.title"),
                        errorMessage,
                        MessageType.DANGER
                )
        );
    }

    private Response<T> coreException(Throwable throwable) {
        CoreException coreException = (CoreException) throwable.getCause();

        if(coreException.getExceptionType() == ExceptionType.DUPLICATE_KEY){
            return duplicateKey(coreException.getMessage());
        }

        else if(coreException.getExceptionType() == ExceptionType.NO_ENTITY) {
            return noEntity(coreException.getMessage());
        }
        else
            return unknownError(coreException.getMessage());
    }

     Response<T> exception(Throwable throwable) {
        Throwable cause = throwable.getCause();

        if (cause instanceof NullPointerException)
            return nullPointerException();
        else if (cause instanceof CoreException)
            return coreException(throwable);

        else
            return unknownError("");
    }
}

