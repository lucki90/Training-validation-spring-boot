package pl.lucky.constraint;


import pl.lucky.common.Lang;
import pl.lucky.validator.BadWordValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {BadWordValidator.class})
@Target({METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface NotBadWord {
    String message() default "You cannot use bad words in your messages";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Lang[] lang() default Lang.PL;
}