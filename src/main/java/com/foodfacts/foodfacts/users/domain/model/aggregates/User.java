package com.foodfacts.foodfacts.users.domain.model.aggregates;

import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.valueobjects.EmailAddress;
import com.foodfacts.foodfacts.users.domain.model.valueobjects.FullName;
import com.foodfacts.foodfacts.users.domain.model.valueobjects.Password;
import com.foodfacts.foodfacts.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

/**
 * User Aggregate Root
 */
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @Embedded
    private FullName fullName;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "email_address"))})
    private EmailAddress emailAddress;

    @Getter
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "password"))})
    private Password password;

    @Getter
    private LocalDate dateOfBirth;

    // Existing constructors...

    // Getters and other methods...

    public String getFullName() {
        return fullName.firstName() + " " + fullName.lastName();
    }

    public String getEmailAddress() {
        return emailAddress.value();
    }

    public void updateFullName(String firstName, String lastName) {
        this.fullName = new FullName(firstName, lastName);
    }

    public void updateEmailAddress(String email) {
        this.emailAddress = new EmailAddress(email);
    }

    public void updatePassword(String password) {
        this.password = new Password(password);
    }
}