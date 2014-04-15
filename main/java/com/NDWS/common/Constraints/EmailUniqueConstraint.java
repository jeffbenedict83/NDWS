package com.NDWS.common.Constraints;

import com.NDWS.common.Validators.EmailUniqueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
@Documented
public @interface EmailUniqueConstraint {

    String message() default "Email is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
