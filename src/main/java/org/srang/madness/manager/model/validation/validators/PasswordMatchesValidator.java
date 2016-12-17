package org.srang.madness.manager.model.validation.validators;

import org.srang.madness.manager.model.forms.RegisterForm;
import org.srang.madness.manager.model.validation.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by srang on 12/17/16.
 */
public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegisterForm registerForm = (RegisterForm) obj;
        return registerForm.getPassword().equals(registerForm.getMatchingPassword());
    }
}