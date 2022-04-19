package com.github.youssfbr.clients.services.exceptions;


public class CpfExistsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CpfExistsException() {
        super("Não foi possível cadastrar. CPF já existente.");
    }
}
