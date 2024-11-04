package com.foodfacts.foodfacts.users.interfaces.rest;

import com.foodfacts.foodfacts.users.application.acl.UsersContextFacadeImpl;
import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Available User Endpoints")
public class UsersController {

    private final UsersContextFacadeImpl usersContextFacade;

    public UsersController(UsersContextFacadeImpl usersContextFacade) {
        this.usersContextFacade = usersContextFacade;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest request) {
        Long userId = usersContextFacade.createUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getDateOfBirth()
        );
        return ResponseEntity.ok(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = usersContextFacade.fetchUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = usersContextFacade.fetchAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request) {
        boolean updated = usersContextFacade.updateUser(
                id,
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getDateOfBirth()
        );
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        boolean deleted = usersContextFacade.deleteUser(id);
        return ResponseEntity.ok(deleted);
    }
}