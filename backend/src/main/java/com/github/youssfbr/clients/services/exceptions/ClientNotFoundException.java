package com.github.youssfbr.clients.services.exceptions;


public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Client not found with ID " + id);
    }

}
