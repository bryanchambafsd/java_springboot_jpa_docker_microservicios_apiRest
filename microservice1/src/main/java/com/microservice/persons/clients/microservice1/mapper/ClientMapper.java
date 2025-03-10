package com.microservice.persons.clients.microservice1.mapper;

import com.microservice.persons.clients.microservice1.dto.ClientDto;
import com.microservice.persons.clients.microservice1.entity.Client;
import com.microservice.persons.clients.microservice1.entity.Person;

public class ClientMapper {

    public static ClientDto mapToClientDto (Client client){
        return new ClientDto(
            client.getId(),
            client.getPassword(),
            client.getState(),
            client.getIdPerson().getId()
        );
    }

    public static Client mapToClient (ClientDto clientDto, Person person){
        return new Client(
            clientDto.getId(),
            clientDto.getPassword(),
            clientDto.getState(),
            person
        );
    }

}
