package com.github.youssfbr.clients.services.interfaces;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;

import java.util.List;


public interface IClientService {

    List<ClientDTO> listAll();
    ClientDTO findById(Long id);
    MessageResponseDTO createClient(ClientDTO clientDTO);
    MessageResponseDTO updateClient(ClientDTO clientDTO);
    void delete(Long id);

}
