package com.NDWS.common.controller;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserDatingProfile;
import com.NDWS.common.beans.UserFacebookProfilePhoto;
import com.NDWS.common.beans.UserProfile;
import com.NDWS.common.repositories.UserDatingProfileRepository;
import com.NDWS.common.repositories.UserFacebookProfilePhotoRepository;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/9/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DatingProfileController {
    @RequestMapping(value="/datingProfile", method = RequestMethod.GET)
    public ModelAndView datingProfileLanding(ModelMap model) {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        UserDatingProfile returnedUserDatingProfile = null;
        User ndwsUser = null;
        try{
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
            UserRepository repository = context.getBean(UserRepository.class);
            ndwsUser = repository.findByEmailAddress(name);
            if(ndwsUser == null){
                ndwsUser = new User();
            }

            UserDatingProfileRepository userDatingProfileRepository = context.getBean(UserDatingProfileRepository.class);
            UserDatingProfile temp = userDatingProfileRepository.findOne(ndwsUser.getId());
            if(temp != null){
                returnedUserDatingProfile = temp;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        if(returnedUserDatingProfile == null){
            returnedUserDatingProfile = new UserDatingProfile();
        }
        putItemsInModelMap(model);
        return new ModelAndView("datingProfile", "userDatingProfile", returnedUserDatingProfile);
    }

    @RequestMapping(value = "/addOrUpdateUserDatingProfile", method = RequestMethod.POST)
    public ModelAndView addOrUpdateUserDatingProfile(@Valid @ModelAttribute("userDatingProfile") UserDatingProfile userDatingProfile, BindingResult errors, ModelMap model) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserProfile userProfile = null;
        User ndwsUser = null;
        if(errors.hasErrors()){
            putItemsInModelMap(model);
            return new ModelAndView("datingProfile", "userDatingProfile", userDatingProfile);
        }else{
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();

            UserDatingProfile returnedUserDatingProfile = null;
            try{
                UserRepository repository = context.getBean(UserRepository.class);
                ndwsUser = repository.findByEmailAddress(name);
                if(ndwsUser == null){
                    ndwsUser = new User();
                }

                userDatingProfile.setNdwsUserId(ndwsUser.getId());

                UserDatingProfileRepository userDatingProfileRepository = context.getBean(UserDatingProfileRepository.class);
                userDatingProfileRepository.save(userDatingProfile);

                UserProfileRepository userProfileRepository = context.getBean(UserProfileRepository.class);
                userProfile = userProfileRepository.findByNdwsUserId(ndwsUser.getId());
            }catch(Exception e){
                e.printStackTrace();
                return new ModelAndView("datingProfile", "userDatingProfile", userDatingProfile);
            }
        }
        if(userProfile == null){
            userProfile = new UserProfile();
        }
        ProfileController.hasFacebookProfilePhotos(model, context, ndwsUser.getId());
        return new ModelAndView("profile", "userProfile", userProfile);
    }

    private void putItemsInModelMap(ModelMap model){
        Map<String, String > myGender = new HashMap<String, String>();
        myGender.put("female", "Female");
        myGender.put("male", "Male");
        model.put("myGender", myGender);

        Map<String, String > genderInterest = new HashMap<String, String>();
        genderInterest.put("both", "Both");
        genderInterest.put("female", "Female");
        genderInterest.put("male", "Male");
        model.put("genderInterest", genderInterest);

        Map<String, String > age = new HashMap<String, String>();
        age.put("96+", "95+");
        age.put("86 - 95", "86 - 95");
        age.put("76 - 85", "76 - 85");
        age.put("66 - 75", "66 - 75");
        age.put("54 - 65", "54 - 65");
        age.put("43 - 53", "43 - 53");
        age.put("34 - 42", "34 - 42");
        age.put("27 - 33", "27 - 33");
        age.put("22 - 26", "22 - 26");
        age.put("18 - 21", "18 - 21");

        model.put("age", age);
        model.put("ageInterest", age);
    }
}


