package com.github.youssfbr.clients.utils;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.entities.Client;

import java.time.LocalDate;
import java.util.Collections;

public class ClientUtils {

    private static final String FIRST_NAME = "Alisson";
    private static final String LAST_NAME = "Youssf";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long CLIENT_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static ClientDTO createFakeDTO() {
        return ClientDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("20/04/1977")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Client createFakeEntity() {
        return Client.builder()
                .id(CLIENT_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
