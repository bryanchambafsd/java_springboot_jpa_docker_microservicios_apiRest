package com.microservice.persons.clients.microservice1.service;

import java.util.List;

import com.microservice.persons.clients.microservice1.dto.PersonDto;

public interface PersonService {

    List<PersonDto> getAllPersons();
    PersonDto getPersonById(int personId);
    PersonDto createPerson(PersonDto personsDto);
    PersonDto updatePerson(int personId, PersonDto udatedPerson);
    void deletePerson(int personId);
    
}
