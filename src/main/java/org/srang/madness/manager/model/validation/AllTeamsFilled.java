package org.srang.madness.manager.model.validation;

import org.srang.madness.manager.model.validation.validators.AllTeamsFilledValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AllTeamsFilledValidator.class)
@Documented
public @interface AllTeamsFilled {
    String message() default "All spaces must be filled";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}