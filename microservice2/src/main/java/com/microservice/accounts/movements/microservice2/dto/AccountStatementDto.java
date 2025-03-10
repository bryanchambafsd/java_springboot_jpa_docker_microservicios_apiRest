package com.microservice.accounts.movements.microservice2.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatementDto {

    private LocalDate date;
    private String client;
    private String accountNumber;
    private String type;
    private BigDecimal initialBalance;
    private String status;
    private BigDecimal movement;
    private BigDecimal availableBalance;

}
