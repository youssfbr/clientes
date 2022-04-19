package com.github.youssfbr.clients.controllers.exceptions;

import com.github.youssfbr.clients.models.Response;
import com.github.youssfbr.clients.services.exceptions.*;

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

    private static final HttpStatus STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;
    private static final HttpStatus STATUS_NOT_FOUND = HttpStatus.NOT_FOUND;
    private static final HttpStatus STATUS_INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });
        Response<Map<String, String>> response = new Response<>();
        response.setStatusCode(STATUS_BAD_REQUEST.value());
        response.setData(errors);

        return ResponseEntity.status(STATUS_BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Response<String>> handlerClientNotFoundException(ClientNotFoundException ex) {

        Response<String> response = new Response<>();
        response.setStatusCode(STATUS_NOT_FOUND.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(STATUS_NOT_FOUND).body(response);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<Response<String>> handlerInternalServerErrorException(InternalServerErrorException ex) {

        Response<String> response = new Response<>();
        response.setStatusCode(STATUS_INTERNAL_SERVER_ERROR.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(STATUS_INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(ClientIdNotNullException.class)
    public ResponseEntity<Response<String>> ClientIdNotNullExceptionException(ClientIdNotNullException ex) {

        Response<String> response = new Response<>();
        response.setStatusCode(STATUS_BAD_REQUEST.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(STATUS_BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CpfExistsException.class)
    public ResponseEntity<Response<String>> CpfExistsExceptionException(CpfExistsException ex) {

        Response<String> response = new Response<>();
        response.setStatusCode(STATUS_BAD_REQUEST.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(STATUS_BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<Response<String>> EmailExistsExceptionException(EmailExistsException ex) {

        Response<String> response = new Response<>();
        response.setStatusCode(STATUS_BAD_REQUEST.value());
        response.setData(ex.getMessage());

        return ResponseEntity.status(STATUS_BAD_REQUEST).body(response);
    }
}
