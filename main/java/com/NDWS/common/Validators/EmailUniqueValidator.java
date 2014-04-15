package com.NDWS.common.Validators;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.Constraints.EmailUniqueConstraint;
import com.NDWS.common.Constraints.UsernameUniqueConstraint;
import com.NDWS.common.beans.User;
import com.NDWS.common.repositories.UserProfileRepository;
import com.NDWS.common.repositories.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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
public class EmailUniqueValidator implements ConstraintValidator<EmailUniqueConstraint, String>{

    @Override
    public void initialize(EmailUniqueConstraint paramA) {
    }

    @Override
    public boolean isValid(String emailAddress, ConstraintValidatorContext ctx) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserRepository repository = context.getBean(UserRepository.class);
        User temp = repository.getByEmailAddress(emailAddress);
        if(temp != null){
            return false;
        }
        return true;
    }
}
