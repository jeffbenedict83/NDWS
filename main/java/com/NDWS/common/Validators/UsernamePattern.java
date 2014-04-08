package com.NDWS.common.Validators;

import com.NDWS.common.Constraints.Username;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UsernamePattern implements ConstraintValidator<Username, String>{

    @Override
    public void initialize(Username paramA) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext ctx) {
        //put in a regex to only allow valid characters
        return true;
    }
}
