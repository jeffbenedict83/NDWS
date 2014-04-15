package com.NDWS.common.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = com.NDWS.common.Validators.FacebookUsernameUniqueValidator.class)
@Documented
public @interface FacebookUsernameUniqueConstraint {

    String message() default "Facebook username is not unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
