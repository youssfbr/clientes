package com.github.youssfbr.clients.dtos;

import com.github.youssfbr.clients.entities.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank
    @Size(max = 10)
    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @NotBlank(message = "{phoneNumber.required}")
    @Size(min = 8, max = 20, message = "{phoneNumber.size}")
    private String number;

}
