package com.github.youssfbr.clients.controllers.exceptions;

import com.github.youssfbr.clients.model.ErrorMapResponse;
import com.github.youssfbr.clients.model.ErrorResponse;
import com.github.youssfbr.clients.services.exceptions.ClientNotFoundException;
import com.github.youssfbr.clients.services.exceptions.InternalServerErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static com.github.youssfbr.clients.model.ErrorMapResponse.*;
import static com.github.youssfbr.clients.model.ErrorResponse.*;


@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMapResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });
        ErrorMapResponseBuilder errorMap = ErrorMapResponse.builder();
        errorMap.errors(errors)
                .httpStatus(status.value())
                .timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(status).body(errorMap.build());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerClientNotFoundException(ClientNotFoundException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseBuilder error = ErrorResponse.builder();
        error.httpStatus(status.value());
        error.message(ex.getMessage());
        error.timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(status).body(error.build());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handlerInternalServerErrorException(InternalServerErrorException ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponseBuilder error = ErrorResponse.builder();
        error.httpStatus(status.value());
        error.message(ex.getMessage());
        error.timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(status).body(error.build());
    }

}
