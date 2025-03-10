package com.microservice.persons.clients.microservice1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.persons.clients.microservice1.dto.PersonDto;
import com.microservice.persons.clients.microservice1.service.PersonService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personsService;

    // GET ALL PERSONS REST API
    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons() {
        List<PersonDto> persons = personsService.getAllPersons();
        return ResponseEntity.ok(persons);
    }
    
    // GET PERSON REST API
    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable("id") int personId) {
        PersonDto personsDto = personsService.getPersonById(personId);
        return ResponseEntity.ok(personsDto);
    }
    
    // ADD PERSON REST API
    @Validated
    @PostMapping
    public ResponseEntity<PersonDto> createPerson (@Valid @RequestBody PersonDto personsDto){
        PersonDto savedPerson = personsService.createPerson(personsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    // UPDATE PERSON REST API
    @Validated
    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson (@PathVariable("id") int personId, 
                                            @Valid @RequestBody PersonDto updatedPersonDto) {
        PersonDto personDto = personsService.updatePerson(personId, updatedPersonDto);
        return ResponseEntity.ok(personDto);
    }

    // DELETE PERSON REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable("id") int personId){
        personsService.deletePerson(personId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
