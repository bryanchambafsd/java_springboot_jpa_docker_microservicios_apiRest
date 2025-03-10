package com.microservice.accounts.movements.microservice2.service;

import java.util.List;

import com.microservice.accounts.movements.microservice2.dto.MovementDto;

public interface MovementService {

    List<MovementDto> getAllMovements();
    MovementDto getMovementById(Long movementId);
    MovementDto createMovement(MovementDto movementDto);
    MovementDto updateMovement(Long movementId, MovementDto udatedMovement);
    void deleteMovement(Long movementId);

}
