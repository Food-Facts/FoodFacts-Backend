package com.foodfacts.foodfacts.users.application.acl;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.commands.UpdateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByIdQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetAllUsersQuery;
import com.foodfacts.foodfacts.users.domain.services.UserCommandService;
import com.foodfacts.foodfacts.users.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UsersContextFacadeImpl {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UsersContextFacadeImpl(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    public Long createUser(String firstName, String lastName, String email, String password, String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        CreateUserCommand createUserCommand = new CreateUserCommand(firstName, lastName, email, password, dob);
        Optional<User> user = userCommandService.handle(createUserCommand);
        return user.map(User::getId).orElse(0L);
    }

    public User fetchUserById(Long id) {
        GetUserByIdQuery getUserByIdQuery = new GetUserByIdQuery(id);
        Optional<User> user = userQueryService.handle(getUserByIdQuery);
        return user.orElse(null);
    }

    public List<User> fetchAllUsers() {
        GetAllUsersQuery getAllUsersQuery = new GetAllUsersQuery();
        return userQueryService.handle(getAllUsersQuery);
    }

    public boolean updateUser(Long id, String firstName, String lastName, String email, String password, String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        UpdateUserCommand updateUserCommand = new UpdateUserCommand(id, firstName, lastName, email, password, dob);
        Optional<User> user = userCommandService.handle(updateUserCommand);
        return user.isPresent();
    }

    public boolean deleteUser(Long id) {
        return userCommandService.deleteUser(id);
    }
}