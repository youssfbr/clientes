package com.github.youssfbr.clients.services.exceptions;


public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException() {
        super("Internal error identified. Contact support");
    }

}
