package org.srang.madness.manager.model.validation;

import org.srang.madness.manager.model.validation.validators.TeamsExactlyOnceValidator;

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
@Constraint(validatedBy = TeamsExactlyOnceValidator.class)
@Documented
public @interface TeamsExactlyOnce {
    String message() default "Teams can only be entered once";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}