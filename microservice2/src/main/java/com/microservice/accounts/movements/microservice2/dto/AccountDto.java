package com.microservice.accounts.movements.microservice2.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private int id;

    @NotBlank(message = "Account number is required")
    @Size(max = 25, message = "Account number must be at most 25 characters")
    private String number;
    
    @NotBlank(message = "Account type is required")
    @Size(max = 25, message = "Account type must be at most 25 characters")
    private String type;
    
    @NotNull(message = "Id PERSON is required")
    private BigDecimal balance;

    @NotBlank(message = "State is required")
    @Size(max = 1, message = "State must be at most 1 characters")
    private String state;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;

    @NotNull(message = "Id PERSON is required")
    private String idClient;

}
