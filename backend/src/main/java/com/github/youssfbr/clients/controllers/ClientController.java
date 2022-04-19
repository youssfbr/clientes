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
        response.setStatusCode(HttpStatus.OK.value());
        response.setData(clientService.listAll());

        return response;
    }

    @GetMapping("{id}")
    public Response<ClientDTO> findById(@PathVariable Long id) {

        Response<ClientDTO> response = new Response<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setData(clientService.findById(id));

        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @PutMapping
    public MessageResponseDTO updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

}
