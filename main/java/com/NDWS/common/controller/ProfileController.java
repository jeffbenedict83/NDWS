package com.NDWS.common.controller;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserFacebookProfilePhoto;
import com.NDWS.common.beans.UserProfile;
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

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/9/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProfileController {
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView profileLanding(ModelMap model) {

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        UserProfile returnedUserProfile = null;
        User ndwsUser = null;
        try{
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
            UserRepository repository = context.getBean(UserRepository.class);
            ndwsUser = repository.findByEmailAddress(name);
            if(ndwsUser == null){
                ndwsUser = new User();
            }

            UserProfileRepository userProfileRepository = context.getBean(UserProfileRepository.class);
            UserProfile temp = userProfileRepository.findOne(ndwsUser.getId());
            if(temp != null){
                returnedUserProfile = temp;
            }

            hasFacebookProfilePhotos(model, context, ndwsUser.getId());

        }catch(Exception e){
            e.printStackTrace();
        }
        if(returnedUserProfile == null){
            returnedUserProfile = new UserProfile();
        }
        return new ModelAndView("profile", "userProfile", returnedUserProfile);
    }

    public static void hasFacebookProfilePhotos(ModelMap model, AbstractApplicationContext context, int ndwsId){
        UserFacebookProfilePhotoRepository userFacebookProfileRepository = context.getBean(UserFacebookProfilePhotoRepository.class);
        ArrayList<UserFacebookProfilePhoto> userFacebookProfilePhotos = userFacebookProfileRepository.findAllFacebookProfilePhotosForUser(ndwsId);
        if(userFacebookProfilePhotos != null && userFacebookProfilePhotos.size() > 0){
            model.addAttribute("hasFacebookProfilePhotos", "1");
        }else{
            model.addAttribute("hasFacebookProfilePhotos", "0");
        }
    }

    @RequestMapping(value = "/addOrUpdateUserProfile", method = RequestMethod.POST)
    public ModelAndView addOrUpdateUserProfile(@Valid @ModelAttribute("userProfile")UserProfile userProfile, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return new ModelAndView("profile", "userProfile", userProfile);
        }else{
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();

            UserProfile returnedUserProfile = null;
            User ndwsUser = null;
            try{
                AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
                UserRepository repository = context.getBean(UserRepository.class);
                ndwsUser = repository.findByEmailAddress(name);
                if(ndwsUser == null){
                    ndwsUser = new User();
                }

                userProfile.setNdwsUserId(ndwsUser.getId());

                UserProfileRepository userProfileRepository = context.getBean(UserProfileRepository.class);
                userProfileRepository.save(userProfile);
            }catch(Exception e){
                e.printStackTrace();
                return new ModelAndView("profile", "userProfile", userProfile);
            }
        }
        return new ModelAndView("landing");
    }
}


