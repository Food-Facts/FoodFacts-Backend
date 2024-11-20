package com.foodfacts.foodfacts.users.domain.model.commands;

import java.time.LocalDate;

public record UpdateUserCommand(Long userId, String firstName, String lastName, String email, String password,
                                LocalDate dateOfBirth) {
}