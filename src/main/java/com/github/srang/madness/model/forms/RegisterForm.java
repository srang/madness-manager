package com.github.srang.madness.model.forms;

import com.github.srang.madness.model.validation.PasswordMatches;
import com.github.srang.madness.model.validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

//import org.hibernate.validator.constraints.Length;

/**
 * Created by srang on 12/10/16.
 */
@Getter
@Setter
@PasswordMatches(message = "Passwords must match")
public class RegisterForm {
    @NotNull(message = "Email is a required field")
    @Email(message = "Please enter a valid email address")
    String email;
    @NotNull(message="Username is a required field")
    @UniqueUsername(message = "Username must be unique")
    String username;
    @NotNull(message = "First name is a required field")
    String firstName;
    @NotNull(message = "Last name is a required field")
    String lastName;
    @NotNull(message = "Password is a required field")
    @Length(min = 2, max = 44, message = "Please keep password between 2 and 44 characters")
    String password;
    @NotNull(message = "Matching password is a requred field")
    String matchingPassword;
}
