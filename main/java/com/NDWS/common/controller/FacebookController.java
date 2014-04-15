package com.NDWS.common.controller;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserFacebook;
import com.NDWS.common.beans.UserProfile;
import com.NDWS.common.repositories.UserFacebookRepository;
import com.NDWS.common.repositories.UserProfileRepository;
import com.NDWS.common.repositories.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/9/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class FacebookController {
    @RequestMapping(value="/facebookIntegration", method = RequestMethod.GET)
    public ModelAndView facebookIntegrationLanding(ModelMap model) {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        UserFacebook returnedUserFacebook = null;
        User ndwsUser = null;
        try{
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
            UserRepository repository = context.getBean(UserRepository.class);
            ndwsUser = repository.findByEmailAddress(name);
            if(ndwsUser == null){
                ndwsUser = new User();
            }

            UserFacebookRepository userFacebookRepository = context.getBean(UserFacebookRepository.class);
            UserFacebook temp = userFacebookRepository.findByNdwsUserId(ndwsUser.getId());
            if(temp != null){
                returnedUserFacebook = temp;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(returnedUserFacebook == null){
            returnedUserFacebook = new UserFacebook();
        }
        return new ModelAndView("facebookIntegration", "userFacebook", returnedUserFacebook);

    }

    @RequestMapping(value="/addOrUpdateFacebookAccount", method = RequestMethod.POST)
    public ModelAndView profileLanding(@Valid @ModelAttribute("userFacebook")UserFacebook userFacebook, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return new ModelAndView("facebookIntegration", "userFacebook", userFacebook);
        }else{
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();

            UserProfile returnedUserFacebook = null;
            User ndwsUser = null;
            try{
                AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
                UserRepository repository = context.getBean(UserRepository.class);
                ndwsUser = repository.findByEmailAddress(name);
                if(ndwsUser == null){
                    ndwsUser = new User();
                }

                userFacebook.setNdwsUserId(ndwsUser.getId());

                UserFacebookRepository userFacebookRepository = context.getBean(UserFacebookRepository.class);
                userFacebook.setFacebookPassword(UserController.sha(userFacebook.getFacebookPassword()));
                userFacebookRepository.save(userFacebook);
            }catch(Exception e){
                e.printStackTrace();
                return new ModelAndView("facebookIntegration", "userFacebook", userFacebook);
            }
        }
        return new ModelAndView("landing");
    }
}


