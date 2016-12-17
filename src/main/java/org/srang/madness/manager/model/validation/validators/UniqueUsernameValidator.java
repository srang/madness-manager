package org.srang.madness.manager.model.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.srang.madness.manager.model.repositories.UserRepository;
import org.srang.madness.manager.model.validation.UniqueUsername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by srang on 12/11/16.
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UniqueUsername uniqueUsername) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;
        if ( username == null ) {
            return isValid;
        }
        isValid = !userRepository.existsByUsername(username);
        if ( !isValid ) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("username not unique").addConstraintViolation();
        }

        return isValid;
    }
}
