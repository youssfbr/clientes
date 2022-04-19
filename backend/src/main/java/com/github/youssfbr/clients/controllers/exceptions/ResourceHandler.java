package com.github.youssfbr.clients.controllers.exceptions;

import com.github.youssfbr.clients.models.Response;
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


@ControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });
        Response<Map<String, String>> response = new Response<>();
        response.setStatusCode(status.value());
        response.setData(errors);

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Response<String>> handlerClientNotFoundException(ClientNotFoundException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        Response<String> response = new Response<>();
        response.setStatusCode(status.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Response<String>> handlerInternalServerErrorException(InternalServerErrorException ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        Response<String> response = new Response<>();
        response.setStatusCode(status.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(status).body(response);
    }

}
