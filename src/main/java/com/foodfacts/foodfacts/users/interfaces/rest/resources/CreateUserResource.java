package com.foodfacts.foodfacts.users.interfaces.rest.resources;

import java.time.LocalDate;

/**
 * Resource for creating a user.
 */
public record CreateUserResource(
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate dateOfBirth) {
    /**
     * Validates the resource.
     *
     * @throws IllegalArgumentException if the resource is invalid.
     */
    public CreateUserResource {
        if (firstName == null || firstName.isBlank()) throw new IllegalArgumentException("First name is required");
        if (lastName == null || lastName.isBlank()) throw new IllegalArgumentException("Last name is required");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email is required");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("Password is required");
        if (dateOfBirth == null) throw new IllegalArgumentException("Date of birth is required");
    }
}
