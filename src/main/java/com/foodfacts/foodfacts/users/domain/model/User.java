package com.foodfacts.foodfacts.users.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "FirstName", example = "John")
    private String firstName;

    @Schema(description = "LastName", example = "Doe")
    private String lastName;

    @Schema(description = "Email", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Password", example = "password123")
    private String password;

    @Schema(description = "Date_of_birth ", example = "1990-01-01")
    private String dateOfBirth;
}