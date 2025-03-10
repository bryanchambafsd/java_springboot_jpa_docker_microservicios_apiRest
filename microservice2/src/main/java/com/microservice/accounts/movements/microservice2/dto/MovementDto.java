package com.microservice.accounts.movements.microservice2.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovementDto {

    private Long id;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Date cannot be in the future")
    private LocalDate date;

    @NotBlank(message = "Movement type is required")
    @Size(max = 25, message = "Account type must be at most 25 characters")
    private String type;

    @NotNull(message = "Value is required")
    private BigDecimal value;

    @NotNull(message = "Balance is required")
    private BigDecimal balance;

    @NotBlank(message = "State is required")
    @Size(max = 1, message = "State must be at most 1 characters")
    private String state;

    @NotNull(message = "Id ACCOUNT is required")
    private int accountId;

}
