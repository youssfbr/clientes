package com.github.youssfbr.clients.controllers;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.models.Response;
import com.github.youssfbr.clients.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    public Response<List<ClientDTO>> listAll() {

        Response<List<ClientDTO>> response = new Response<>();
        response.setData(clientService.listAll());

        return response;
    }

    @GetMapping("{id}")
    public Response<ClientDTO> findById(@PathVariable Long id) {

        Response<ClientDTO> response = new Response<>();
        response.setData(clientService.findById(id));

        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<MessageResponseDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {

        Response<MessageResponseDTO> response = new Response<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setData(clientService.createClient(clientDTO));

        return response;
    }

    @PutMapping
    public Response<MessageResponseDTO> updateClient(@RequestBody @Valid ClientDTO clientDTO) {

        Response<MessageResponseDTO> response = new Response<>();
        response.setData(clientService.updateClient(clientDTO));

        return response;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
