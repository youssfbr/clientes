package com.github.youssfbr.clients.dtos;

import lombok.*;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "{firstName.required}")
    @Size(min = 2, max = 20, message = "{firstName.size}")
    private String firstName;

    @NotBlank(message = "{lastName.required}")
    @Size(min = 2, max = 20, message = "{lastName.size}")
    private String lastName;

    @CPF(message = "{cpf.invalid}")
    @Size(max = 14, message = "{cpf.size}")
    private String cpf;

    private String birthDate;

    private String registerDate;

    // TO DO ADDRESS

    // CONTACT
    @Size(max = 20)
    private String phone;

    @Email
    @Size(max = 40)
    private String email1;

    private String note;

    private List<PhoneDTO> phones;

}
