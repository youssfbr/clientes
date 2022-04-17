package com.github.youssfbr.clients.services;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.dtos.MessageResponseDTO;
import com.github.youssfbr.clients.entities.Client;
import com.github.youssfbr.clients.repositories.IClientRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.youssfbr.clients.utils.ClientUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private IClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void testGivenClientDTOThenReturnSavedMessage() {
        ClientDTO clientDTO = createFakeDTO();
        Client expectedSavedClient = createFakeEntity();

        when(clientRepository.save(any(Client.class))).thenReturn(expectedSavedClient);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedClient.getId());
        MessageResponseDTO successMessage = clientService.createClient(clientDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created client with ID " + id)
                .build();
    }

}
