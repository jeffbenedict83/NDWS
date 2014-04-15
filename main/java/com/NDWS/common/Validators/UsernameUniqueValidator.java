package com.NDWS.common.Validators;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.Constraints.UsernameUniqueConstraint;
import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserProfile;
import com.NDWS.common.repositories.UserProfileRepository;
import com.NDWS.common.repositories.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UsernameUniqueValidator implements ConstraintValidator<UsernameUniqueConstraint, String>{

    @Override
    public void initialize(UsernameUniqueConstraint paramA) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext ctx) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        UserRepository userRepository = context.getBean(UserRepository.class);
        User ndwsUser = userRepository.findByEmailAddress(name);

        UserProfileRepository userProfileRepository = context.getBean(UserProfileRepository.class);
        UserProfile temp = userProfileRepository.getByUsernameAndNdwsUserIdNot(username, ndwsUser.getId());
        //need to remove current user as an option
        if(temp != null){
            return false;
        }
        return true;
    }
}
