package com.github.youssfbr.clients.controllers;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class  ClientController {

    private final IClientService clientService;

    @GetMapping
    public List<ClientDTO> listAll() {
        return clientService.listAll();
    }

    @GetMapping("{id}")
    public ClientDTO findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
