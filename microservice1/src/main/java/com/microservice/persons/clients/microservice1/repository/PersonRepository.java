package com.microservice.persons.clients.microservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.persons.clients.microservice1.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
