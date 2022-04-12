package com.github.youssfbr.clients.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus {

    SOLTEIRO("Solteiro"),
    DIVORCIADO("Divorciado");

    private final String description;

}
