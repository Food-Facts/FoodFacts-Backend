package com.foodfacts.foodfacts.profiles.interfaces.rest.transform;

import com.foodfacts.foodfacts.profiles.domain.model.commands.CreateProfileCommand;
import com.foodfacts.foodfacts.profiles.interfaces.rest.resources.CreateProfileResource;

/**
 * Assembler to convert a CreateProfileResource to a CreateProfileCommand.
 */
public class CreateProfileCommandFromResourceAssembler {
    /**
     * Converts a CreateProfileResource to a CreateProfileCommand.
     * @param resource The {@link CreateProfileResource} resource to convert.
     * @return The {@link CreateProfileCommand} command.
     */
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.street(),
                resource.number(),
                resource.city(),
                resource.postalCode(),
                resource.country());
    }
}