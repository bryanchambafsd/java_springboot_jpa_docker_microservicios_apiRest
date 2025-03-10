package com.microservice.persons.clients.microservice1.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private int id;

    @NotBlank(message = "Identification is required")
    @Size(max = 50, message = "Identification must be at most 50 characters")
    private String identification;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be at most 255 characters")
    private String name;

    @NotBlank(message = "Gender is required")
    @Size(max = 25, message = "Gender must be at most 25 characters")
    private String gender;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 150, message = "Age must be at most 150")
    private Short age;

    @NotBlank(message = "Direction is required")
    @Size(max = 255, message = "Direction must be at most 255 characters")
    private String direcction;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Invalid phone number")
    private String phone;
}
