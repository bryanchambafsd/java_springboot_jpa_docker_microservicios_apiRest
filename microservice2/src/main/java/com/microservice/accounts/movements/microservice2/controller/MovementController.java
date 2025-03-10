package com.microservice.accounts.movements.microservice2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.accounts.movements.microservice2.dto.AccountStatementDto;
import com.microservice.accounts.movements.microservice2.dto.MovementDto;
import com.microservice.accounts.movements.microservice2.service.AccountStatementService;
import com.microservice.accounts.movements.microservice2.service.MovementService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/movements")
public class MovementController {

    private MovementService movmentService;
    private AccountStatementService accountStatementService;

    // GET ALL ACCOUNTS REST API
    @GetMapping
    public ResponseEntity<List<MovementDto>> getMovements() {
        List<MovementDto> account = movmentService.getAllMovements();
        return ResponseEntity.ok(account);
    }

    // GET ACCOUNT REST API
    @GetMapping("/{id}")
    public ResponseEntity<MovementDto> getMovementById(@PathVariable("id") Long movementId) {
        MovementDto accountDto = movmentService.getMovementById(movementId);
        return ResponseEntity.ok(accountDto);
    }
    
    // ADD ACCOUNT REST API
    @Validated
    @PostMapping
    public ResponseEntity<MovementDto> createMovement (@Valid @RequestBody MovementDto accountDto){
        MovementDto savedMovement = movmentService.createMovement(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovement);
    }

    // UPDATE ACCOUNT REST API
    @Validated
    @PutMapping("/{id}")
    public ResponseEntity<MovementDto> updateMovement (@PathVariable("id") Long movementId, 
                                            @Valid @RequestBody MovementDto updatedMovementDto) {
        MovementDto accountDto = movmentService.updateMovement(movementId, updatedMovementDto);
        return ResponseEntity.ok(accountDto);
    }

    // SOFT DELETE ACCOUNT REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable("id") Long movementId){
        movmentService.deleteMovement(movementId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/report")
    public ResponseEntity<List<AccountStatementDto>> getAccountStatement(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate) {
        
        List<AccountStatementDto> statement = accountStatementService.getReport(startDate, endDate);
        return ResponseEntity.ok(statement);
    }


}
