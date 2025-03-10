package com.microservice.persons.clients.microservice1.mapper;

import com.microservice.persons.clients.microservice1.dto.PersonDto;
import com.microservice.persons.clients.microservice1.entity.Person;

public class PersonMapper {

    public static PersonDto mapToPersonsDto (Person person){
        return new PersonDto(
            person.getId(),
            person.getIdentification(),
            person.getName(),
            person.getGender(),
            person.getAge(),
            person.getDirection(),
            person.getPhone()
        );
    }

    public static Person mapToPerson (PersonDto personsDto){
        return new Person(
            personsDto.getId(),
            personsDto.getIdentification(),
            personsDto.getName(),
            personsDto.getGender(),
            personsDto.getAge(),
            personsDto.getDirecction(),
            personsDto.getPhone()
        );
    }

}
