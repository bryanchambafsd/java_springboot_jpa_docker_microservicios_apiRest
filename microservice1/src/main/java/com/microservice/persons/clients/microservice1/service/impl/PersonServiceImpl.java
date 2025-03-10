package com.microservice.persons.clients.microservice1.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.persons.clients.microservice1.dto.PersonDto;
import com.microservice.persons.clients.microservice1.entity.Person;
import com.microservice.persons.clients.microservice1.exception.ResourseNotFoundException;
import com.microservice.persons.clients.microservice1.mapper.PersonMapper;
import com.microservice.persons.clients.microservice1.repository.PersonRepository;
import com.microservice.persons.clients.microservice1.service.PersonService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{

    private PersonRepository personRepository;

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> person = personRepository.findAll();
        return person.stream().map((persons) -> PersonMapper.mapToPersonsDto(persons)).toList();
    }

    @Override
    public PersonDto getPersonById(int personId) {
        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new ResourseNotFoundException("Person is not exists with the given ID: " + personId));
        return PersonMapper.mapToPersonsDto(person);
    }

    @Override
    public PersonDto createPerson(PersonDto personsDto) {
        Person person = PersonMapper.mapToPerson(personsDto);
        Person savePerson = personRepository.save(person);
        return PersonMapper.mapToPersonsDto(savePerson);
    }

    @Override
    public PersonDto updatePerson(int personId, PersonDto udatedPerson) {
        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new ResourseNotFoundException("Person is not exists with the given ID: " + personId));
        
        person.setIdentification(udatedPerson.getIdentification());
        person.setName(udatedPerson.getName());
        person.setGender(udatedPerson.getGender());
        person.setAge(udatedPerson.getAge());
        person.setDirection(udatedPerson.getDirecction());
        person.setPhone(udatedPerson.getPhone());

        Person updatedPersonObj = personRepository.save(person);

        return PersonMapper.mapToPersonsDto(updatedPersonObj);
    }

    @Override
    public void deletePerson(int personId) {
        personRepository.findById(personId)
        .ifPresentOrElse(personRepository::delete, 
            () -> { throw new ResourseNotFoundException("Person does not exist with ID: " + personId); });
    }

}
