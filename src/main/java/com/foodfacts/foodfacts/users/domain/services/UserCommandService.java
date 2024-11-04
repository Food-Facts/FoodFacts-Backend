package com.foodfacts.foodfacts.users.domain.services;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.commands.UpdateUserCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserCommandService {
    /**
     * Handle Create User Command
     *
     * @param command The {@link CreateUserCommand} Command
     * @return A {@link User} instance if the command is valid, otherwise empty
     */
    Optional<User> handle(CreateUserCommand command);

    /**
     * Handle Update User Command
     *
     * @param command The {@link UpdateUserCommand} Command
     * @return A {@link User} instance if the command is valid, otherwise empty
     */
    Optional<User> handle(UpdateUserCommand command);

    /**
     * Delete User by ID
     *
     * @param userId The user ID
     * @return true if the user was deleted, false otherwise
     */
    boolean deleteUser(Long userId);
}