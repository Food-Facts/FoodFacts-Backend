package com.foodfacts.foodfacts.users.interfaces.rest.resources;


import java.time.LocalDate;

/**
 * Resource for a user.
 */
public record UserResource(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate dateOfBirth) {
}