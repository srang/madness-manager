package com.github.srang.madness.model.validation.validators;

import com.github.srang.madness.model.forms.CreateMasterBracketForm;
import com.github.srang.madness.model.validation.TeamsExactlyOnce;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by srang on 12/17/16.
 */
public class TeamsExactlyOnceValidator
        implements ConstraintValidator<TeamsExactlyOnce, Object> {

    @Override
    public void initialize(TeamsExactlyOnce constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        CreateMasterBracketForm masterBracketForm = (CreateMasterBracketForm) obj;
        List<Integer> teams = masterBracketForm
                .getRankedTeams().values().stream()
                .flatMap(m -> m.values().stream())
                .filter(t -> t != null).collect(toList());
        long teamsCount = teams.size();
        long reduced = teams.stream().distinct().count();
        return teamsCount == reduced;
    }
}