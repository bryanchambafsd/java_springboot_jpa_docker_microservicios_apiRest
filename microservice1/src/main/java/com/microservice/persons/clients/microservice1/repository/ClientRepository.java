package com.microservice.persons.clients.microservice1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.persons.clients.microservice1.entity.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

    List<Client> findByState(String state);

    Optional<Client> findByIdAndState(String id, String state);

}
