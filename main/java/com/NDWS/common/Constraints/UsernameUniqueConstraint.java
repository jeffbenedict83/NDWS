package com.NDWS.common.Constraints;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = com.NDWS.common.Validators.UsernameUniqueValidator.class)
@Documented
public @interface UsernameUniqueConstraint {

    String message() default "Username is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
