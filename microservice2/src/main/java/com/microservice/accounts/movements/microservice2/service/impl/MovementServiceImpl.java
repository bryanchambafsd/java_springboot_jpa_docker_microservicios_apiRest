package com.microservice.accounts.movements.microservice2.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.accounts.movements.microservice2.dto.MovementDto;
import com.microservice.accounts.movements.microservice2.entity.Account;
import com.microservice.accounts.movements.microservice2.entity.Movement;
import com.microservice.accounts.movements.microservice2.exception.ResourceConflictException;
import com.microservice.accounts.movements.microservice2.exception.ResourseNotFoundException;
import com.microservice.accounts.movements.microservice2.mapper.MovementMapper;
import com.microservice.accounts.movements.microservice2.repository.AccountRepository;
import com.microservice.accounts.movements.microservice2.repository.MovementRepository;
import com.microservice.accounts.movements.microservice2.service.MovementService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovementServiceImpl implements MovementService{

    private MovementRepository movementRepository;
    private AccountRepository accountRepository;

    @Override
    public List<MovementDto> getAllMovements() {
        List<Movement> movement = movementRepository.findAll();
        return movement.stream().map((movements) -> MovementMapper.mapToMovementDto(movements)).toList();
    }

    @Override
    public MovementDto getMovementById(Long movementId) {
        Movement movement = movementRepository.findById(movementId)
            .orElseThrow(() -> new ResourseNotFoundException("Movement is not exists with the given ID: " + movementId));
        return MovementMapper.mapToMovementDto(movement);
    }

    @Override
    @Transactional
    public MovementDto createMovement(MovementDto movementDto) {
        // Buscar la cuenta
        Account account = accountRepository.findById(movementDto.getAccountId())
            .orElseThrow(() -> new ResourseNotFoundException("Account not found with ID: " + movementDto.getAccountId()));

        // Verificar saldo suficiente para retiros
        if (movementDto.getValue().compareTo(BigDecimal.ZERO) < 0) {
            BigDecimal newBalance = account.getBalance().add(movementDto.getValue()); // Restar el retiro
            if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
                throw new ResourceConflictException("Saldo no disponible");
            }
            account.setBalance(newBalance);
        } else {
            // Sumar depósitos
            account.setBalance(account.getBalance().add(movementDto.getValue()));
        }

        // Guardar el nuevo saldo en la cuenta
        accountRepository.save(account);

        // Crear y guardar el movimiento
        Movement movement = new Movement();
        movement.setDate(LocalDate.now());
        movement.setType(movementDto.getType());
        movement.setValue(movementDto.getValue());
        movement.setBalance(account.getBalance());
        movement.setState(movementDto.getState());
        movement.setAccountId(account);

        movementRepository.save(movement);

        return MovementMapper.mapToMovementDto(movement);
    }

    @Override
    public MovementDto updateMovement(Long movementId, MovementDto udatedMovement) {
        Movement movement = movementRepository.findById(movementId)
            .orElseThrow(() -> new ResourseNotFoundException("Movement is not exists with the given ID: " + movementId));
        
        movement.setDate(udatedMovement.getDate());
        movement.setType(udatedMovement.getType());
        movement.setValue(udatedMovement.getValue());
        movement.setBalance(udatedMovement.getBalance());

        Movement updatedMovementObj = movementRepository.save(movement);

        return MovementMapper.mapToMovementDto(updatedMovementObj);
    }

    @Override
    public void deleteMovement(Long movementId) {
        Movement movement = movementRepository.findById(movementId)
            .orElseThrow(() -> new ResourseNotFoundException("Movement not found with ID: " + movementId));

        movement.setState("I");
        movementRepository.save(movement);
    }

}
