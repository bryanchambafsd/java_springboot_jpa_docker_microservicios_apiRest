package com.microservice.persons.clients.microservice1.service;

import java.util.List;

import com.microservice.persons.clients.microservice1.dto.ClientDto;

public interface ClientService {

    List<ClientDto> getAllClients();
    ClientDto getClientById(String clientId);
    ClientDto createClient(ClientDto clientsDto);
    ClientDto updateClient(String clientId, ClientDto udatedClient);
    void deleteClient(String clientId);
    void activateClient(String clientId);
    
}
