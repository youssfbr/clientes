package com.github.youssfbr.clients.repositories;

import com.github.youssfbr.clients.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByEmail1(String email1);

}
