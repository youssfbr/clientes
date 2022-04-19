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

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 20, message = "O nome deve ter entre 2 a 20 caracteres.")
    private String firstName;

    @NotBlank(message = "O sobrenome é obrigatório.")
    @Size(min = 2, max = 20, message = "O sobrenome deve ter entre 2 a 20 caracteres.")
    private String lastName;

    @CPF(message = "O CPF está incorreto.")
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


    private void setCpf(String cpf) {
        if(cpf != null && cpf.length() == 0) {
            this.cpf = null;
        }
        else {
            this.cpf = cpf;
        }
    }

    private void setEmail1(String email1) {
        if(email1 != null && email1.length() == 0) {
            this.email1 = null;
        }
        else {
            this.email1 = email1;
        }
    }

    private void setBirthDate(String birthDate) {
        if(birthDate != null && birthDate.length() == 0) {
            this.birthDate = null;
        }
        else {
            this.birthDate = birthDate;
        }
    }

}
