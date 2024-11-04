package com.foodfacts.foodfacts.profiles.domain.services;

import com.foodfacts.foodfacts.profiles.domain.model.aggregates.Profile;
import com.foodfacts.foodfacts.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;


import org.springframework.stereotype.Service;

@Service
public interface ProfileCommandService {
    /**
     * Handle Create Profile Command
     *
     * @param command The {@link CreateProfileCommand} Command
     * @return A {@link Profile} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if the email address already exists
     */
    Optional<Profile> handle(CreateProfileCommand command);
}