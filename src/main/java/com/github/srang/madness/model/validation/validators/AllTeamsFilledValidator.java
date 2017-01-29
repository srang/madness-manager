package com.github.srang.madness.model.validation.validators;

import com.github.srang.madness.model.forms.CreateMasterBracketForm;
import com.github.srang.madness.model.validation.AllTeamsFilled;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
        if (!masterBracketForm.getMadnessFlag()) {
            // only validate when final sumbission
            return true;
        }
        List<Integer> teams = masterBracketForm
                .getRankedTeams().values().stream()
                .flatMap(m -> m.values().stream())
                .collect(toList());
        long teamsCount = teams.size();
        long reduced = teams.stream().filter(t -> t != null).distinct().count();
        return teamsCount == reduced;
    }
}