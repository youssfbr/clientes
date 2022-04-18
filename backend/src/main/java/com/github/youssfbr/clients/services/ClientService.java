package com.github.youssfbr.clients.services;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.entities.Client;
import com.github.youssfbr.clients.mapper.ClientMapper;
import com.github.youssfbr.clients.repositories.IClientRepository;
import com.github.youssfbr.clients.services.exceptions.ClientNotFoundException;
import com.github.youssfbr.clients.services.exceptions.InternalServerErrorException;
import com.github.youssfbr.clients.services.interfaces.IClientService;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "client")
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;
    private static final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Override
    @CachePut(unless = "#result.size()<3")
    @Transactional(readOnly = true)
    public List<ClientDTO> listAll() {
        try {
            return clientRepository
                    .findAll()
                    .stream()
                    .map(clientMapper::toDTO)
                    .collect(Collectors.toList());
        }
        catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @Override
    @CachePut(key = "#id")
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        try {
            return clientRepository
                    .findById(id)
                    .map(clientMapper::toDTO)
                    .orElseThrow(() -> new ClientNotFoundException(id));
        }
        catch (ClientNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @Override
    @Transactional
    public MessageResponseDTO createClient(ClientDTO clientDTO) {
        try {
            Client clientToSave = clientMapper.toModel(clientDTO);
            Client savedClient = clientRepository.save(clientToSave);

            return createMessageResponse(savedClient.getId(), "Created client with ID ");
        }
        catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @Override
    @Transactional
    public MessageResponseDTO updateClient(ClientDTO clientDTO) {
        try {
            verifyIfExists(clientDTO.getId());

            Client clientToUpdate = clientMapper.toModel(clientDTO);
            Client updatedClient = clientRepository.save(clientToUpdate);

            return createMessageResponse(updatedClient.getId(), "Updated client with ID ");
        }
        catch (ClientNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            verifyIfExists(id);
            clientRepository.deleteById(id);
        }
        catch (ClientNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    private Client verifyIfExists(Long id) {
        return clientRepository
                .findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
