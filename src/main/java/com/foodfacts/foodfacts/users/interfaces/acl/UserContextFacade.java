package com.foodfacts.foodfacts.users.interfaces.acl;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.commands.UpdateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.queries.GetAllUsersQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByEmailQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByIdQuery;
import com.foodfacts.foodfacts.users.domain.services.UserCommandService;
import com.foodfacts.foodfacts.users.domain.services.UserQueryService;
import com.foodfacts.foodfacts.users.domain.model.valueobjects.EmailAddress;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class UserContextFacade {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public User createUser(CreateUserCommand command) {
        return userCommandService.handle(command).orElse(null);
    }

    public void updateUser(Long userId, String firstName, String lastName, String email, String password) {
        LocalDate currentDate = LocalDate.now(); // O cualquier otra fecha que necesites
        UpdateUserCommand command = new UpdateUserCommand(userId, firstName, lastName, email, password, currentDate);
        userCommandService.handle(command);
    }

    public User getUserById(Long userId) {
        return userQueryService.handle(new GetUserByIdQuery(userId)).orElse(null);
    }

    public User getUserByEmail(String email) {
        return userQueryService.handle(new GetUserByEmailQuery(new EmailAddress(email))).orElse(null);
    }

    public List<User> getAllUsers() {
        return userQueryService.handle(new GetAllUsersQuery());
    }
}