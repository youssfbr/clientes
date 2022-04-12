package com.github.youssfbr.clients.services.interfaces;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.entities.Client;

import java.util.List;


public interface IClientService {

    List<ClientDTO> listAll();
    ClientDTO findById(Long id);
    MessageResponseDTO createClient(ClientDTO clientDTO);
    MessageResponseDTO update(Client client);
    void delete(Long id);

}
