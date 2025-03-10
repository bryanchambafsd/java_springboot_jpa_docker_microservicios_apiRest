package com.microservice.accounts.movements.microservice2.mapper;

import com.microservice.accounts.movements.microservice2.dto.MovementDto;
import com.microservice.accounts.movements.microservice2.entity.Account;
import com.microservice.accounts.movements.microservice2.entity.Movement;

public class MovementMapper {

    public static MovementDto mapToMovementDto (Movement movement) {
        return new MovementDto(
            movement.getId(),
            movement.getDate(),
            movement.getType(),
            movement.getValue(),
            movement.getBalance(),
            movement.getState(),
            movement.getAccountId().getId()
        );
    }

    public static Movement mapToMovement (MovementDto movementDto, Account account) {
        return new Movement(
            movementDto.getId(),
            movementDto.getDate(),
            movementDto.getType(),
            movementDto.getValue(),
            movementDto.getBalance(),
            movementDto.getState(),
            account
        );
    }

}
