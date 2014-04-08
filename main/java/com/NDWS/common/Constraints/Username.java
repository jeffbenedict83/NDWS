package com.NDWS.common.Constraints;

import com.NDWS.common.Validators.UniqueUsernameValidator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Documented
public @interface Username {

    String message() default "Username is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
