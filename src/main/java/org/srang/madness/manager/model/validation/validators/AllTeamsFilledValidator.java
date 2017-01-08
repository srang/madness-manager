package org.srang.madness.manager.model.validation.validators;

import org.srang.madness.manager.model.forms.CreateMasterBracketForm;
import org.srang.madness.manager.model.validation.AllTeamsFilled;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by srang on 12/17/16.
 */
public class AllTeamsFilledValidator
        implements ConstraintValidator<AllTeamsFilled, Object> {

    @Override
    public void initialize(AllTeamsFilled constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        CreateMasterBracketForm masterBracketForm = (CreateMasterBracketForm) obj;
        return true;
    }
}