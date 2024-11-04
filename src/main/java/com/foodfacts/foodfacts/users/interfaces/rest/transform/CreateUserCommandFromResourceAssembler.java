package com.foodfacts.foodfacts.users.interfaces.rest.transform;

import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.interfaces.rest.resources.CreateUserResource;

/**
 * Assembler to convert a CreateUserResource to a CreateUserCommand.
 */
public class CreateUserCommandFromResourceAssembler {
    /**
     * Converts a CreateUserResource to a CreateUserCommand.
     * @param resource The {@link CreateUserResource} resource to convert.
     * @return The {@link CreateUserCommand} command.
     */
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.password(),
                resource.dateOfBirth());
    }
}