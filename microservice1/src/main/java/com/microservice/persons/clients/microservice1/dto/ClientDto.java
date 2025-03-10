package com.microservice.persons.clients.microservice1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    @NotBlank(message = "Id is required")
    @Size(max = 25, message = "Id must be at most 25 characters")
    private String id;

    @NotBlank(message = "Password is required")
    @Size(max = 255, message = "Password must be at most 255 characters")
    private String password;
    
    @NotBlank(message = "State is required")
    @Size(max = 1, message = "State must be at most 1 characters")
    private String state;

    @NotNull(message = "Id PERSON is required")
    private int idPerson;

}
