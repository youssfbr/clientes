package com.github.youssfbr.clients.services;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.entities.Client;
import com.github.youssfbr.clients.mapper.ClientMapper;
import com.github.youssfbr.clients.repositories.IClientRepository;
import com.github.youssfbr.clients.services.exceptions.ClientNotFoundException;
import com.github.youssfbr.clients.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;
    private static final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    @Transactional(readOnly = true)
    public List<ClientDTO> listAll() {

        List<Client> allClients = clientRepository.findAll();

        return allClients.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        return clientRepository
                .findById(id)
                .map(clientMapper::toDTO)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    @Override
    @Transactional
    public MessageResponseDTO createClient(ClientDTO clientDTO) {

        Client client = clientMapper.toModel(clientDTO);
        client = clientRepository.save(client);

        return MessageResponseDTO
                .builder()
                .message("Client created with ID " + client.getId())
                .build();
    }

    @Override
    @Transactional
    public MessageResponseDTO update(Client client) {
        return null;
    }

    @Override
    public void delete(Long id) {

        verifyIfExists(id);

        clientRepository.deleteById(id);
    }

    private Client verifyIfExists(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }


}
