package com.microservice.accounts.movements.microservice2.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.accounts.movements.microservice2.dto.AccountStatementDto;
import com.microservice.accounts.movements.microservice2.repository.AccountStatementRepository;
import com.microservice.accounts.movements.microservice2.service.AccountStatementService;

import jakarta.persistence.EntityManager;

@Service
public class AccountStatementServiceImpl implements AccountStatementService {

    private final AccountStatementRepository accountStatementRepository;

    // Constructor de la clase, donde se instancia manualmente el repositorio
    public AccountStatementServiceImpl(EntityManager entityManager) {
        this.accountStatementRepository = new AccountStatementRepository(entityManager);
    }

    public List<AccountStatementDto> getReport(LocalDate startDate, LocalDate endDate) {
        List<Object[]> results = accountStatementRepository.findAccountStatement(startDate, endDate);
        List<AccountStatementDto> accountStatements = new ArrayList<>();

        for (Object[] result : results) {
            AccountStatementDto dto = new AccountStatementDto();
            dto.setAccountNumber((String) result[0]);
            dto.setType((String) result[1]);
            dto.setInitialBalance((BigDecimal) result[2]);
            dto.setMovement((BigDecimal) result[3]);
            dto.setAvailableBalance((BigDecimal) result[4]);
            
            // Conversión de java.sql.Date a java.time.LocalDate
            Date sqlDate = (Date) result[5]; // Suponiendo que 'result[5]' es la fecha
            LocalDate localDate = sqlDate.toLocalDate();
            dto.setDate(localDate);
            
            dto.setClient((String) result[6]);
            dto.setStatus((String) result[7]);
    
            accountStatements.add(dto);
        }

        return accountStatements;
    }
}
