package com.microservice.accounts.movements.microservice2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.accounts.movements.microservice2.entity.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {

}
