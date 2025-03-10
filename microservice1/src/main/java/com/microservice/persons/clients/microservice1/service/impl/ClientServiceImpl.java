package com.microservice.persons.clients.microservice1.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.persons.clients.microservice1.dto.ClientDto;
import com.microservice.persons.clients.microservice1.entity.Client;
import com.microservice.persons.clients.microservice1.entity.Person;
import com.microservice.persons.clients.microservice1.exception.ResourceConflictException;
import com.microservice.persons.clients.microservice1.exception.ResourseNotFoundException;
import com.microservice.persons.clients.microservice1.mapper.ClientMapper;
import com.microservice.persons.clients.microservice1.repository.ClientRepository;
import com.microservice.persons.clients.microservice1.repository.PersonRepository;
import com.microservice.persons.clients.microservice1.service.ClientService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    PersonRepository personRepository;

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> client = clientRepository.findByState("A");
        return client.stream().map((clients) -> ClientMapper.mapToClientDto(clients)).toList();
    }

    @Override
    public ClientDto getClientById(String clientId) {
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new ResourseNotFoundException("Client is not exist with the given ID: " + clientId));
        return ClientMapper.mapToClientDto(client);
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        if(clientRepository.existsById(clientDto.getId())){
            throw new ResourceConflictException("Client already exists with ID: " + clientDto.getId());
        }

        Person person = personRepository.findById(clientDto.getIdPerson())
            .orElseThrow(() -> new ResourseNotFoundException("Person not found with ID: " + clientDto.getIdPerson()));

        Client client = ClientMapper.mapToClient(clientDto, person);
        Client savedClient = clientRepository.save(client);

        return ClientMapper.mapToClientDto(savedClient);
    }

    @Override
    public ClientDto updateClient(String clientId, ClientDto updatedClient) {
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new ResourseNotFoundException("Client is not exists with the given ID: " + clientId));

        client.setPassword(updatedClient.getPassword());
        client.setState(updatedClient.getState());

        Client updatedClientObj = clientRepository.save(client);

        return ClientMapper.mapToClientDto(updatedClientObj);
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new ResourseNotFoundException("Client not found with ID: " + clientId));

        client.setState("I");
        clientRepository.save(client);
    }

    @Override
    public void activateClient(String clientId) {
        Client client = clientRepository.findById(clientId)
            .orElseThrow(() -> new ResourseNotFoundException("Client not found with ID: " + clientId));

        if ("A".equals(client.getState())) {
            throw new ResourceConflictException("Client is already active with ID: " + clientId);
        }

        client.setState("A");
        clientRepository.save(client);
    }

}
