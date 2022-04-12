package com.github.youssfbr.clients.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientType {

    FISICA("Fisica"),
    JURIDICA("Juridica");

    private final String description;

}
