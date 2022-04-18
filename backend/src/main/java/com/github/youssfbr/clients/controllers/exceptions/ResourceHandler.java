package com.github.youssfbr.clients.controllers.exceptions;

import com.github.youssfbr.clients.model.ErrorResponse;
import com.github.youssfbr.clients.services.exceptions.ClientNotFoundException;

import com.github.youssfbr.clients.services.exceptions.InternalServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.github.youssfbr.clients.model.ErrorResponse.*;

@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerClientNotFoundException(ClientNotFoundException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ErrorResponseBuilder error = builder();
        error.httpStatus(status.value());
        error.message(ex.getMessage());
        error.timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(status).body(error.build());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorResponse> handlerInternalServerErrorException(InternalServerErrorException ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponseBuilder error = builder();
        error.httpStatus(status.value());
        error.message(ex.getMessage());
        error.timeStamp(System.currentTimeMillis());

        return ResponseEntity.status(status).body(error.build());
    }



}
