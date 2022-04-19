package com.github.youssfbr.clients.services.exceptions;


public class EmailExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmailExistsException() {
        super("Não foi possível cadastrar. E-mail já existente.");
    }
}
