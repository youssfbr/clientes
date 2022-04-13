package com.github.youssfbr.clients.mapper;

import com.github.youssfbr.clients.dtos.ClientDTO;
import com.github.youssfbr.clients.entities.Client;

import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    Client toModel(ClientDTO clientDTO);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    ClientDTO toDTO(Client client);

}
