package com.NDWS.common.controller;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.beans.UserFacebookProfilePhoto;
import com.NDWS.common.beans.UserProfile;
import com.NDWS.common.repositories.UserFacebookProfilePhotoRepository;
import com.NDWS.common.repositories.UserProfileRepository;
import com.NDWS.common.repositories.UserRepository;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/6/14
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserFacebookProfilePhotoController {

    @RequestMapping(value="/updatePhotoVisibility", method = RequestMethod.POST)
    public @ResponseBody
    String updatePhotoVisibility(@RequestParam("photoId") String photoId, @RequestParam("visibility") String visibility){

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserFacebookProfilePhotoRepository userFacebookProfileRepository = context.getBean(UserFacebookProfilePhotoRepository.class);
        UserFacebookProfilePhoto userFacebookProfilePhoto = userFacebookProfileRepository.findById(Integer.parseInt(photoId));
        userFacebookProfilePhoto.setVisibility(Integer.parseInt(visibility));
        userFacebookProfileRepository.save(userFacebookProfilePhoto);

        return "success";
    }

    @RequestMapping(value="/getSavedFacebookProfilePhotos", method = RequestMethod.GET)
    public @ResponseBody
    String getSavedFacebookProfilePhotos() {
        String retVal = "";


        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        com.NDWS.common.beans.User ndwsUser = null;
        try{
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
            UserRepository repository = context.getBean(UserRepository.class);
            ndwsUser = repository.findByEmailAddress(name);
            if(ndwsUser == null){
                ndwsUser = new com.NDWS.common.beans.User();
            }
            UserFacebookProfilePhotoRepository userFacebookProfileRepository = context.getBean(UserFacebookProfilePhotoRepository.class);

            ArrayList<UserFacebookProfilePhoto> userFacebookProfilePhotos = userFacebookProfileRepository.findAllFacebookProfilePhotosForUser(ndwsUser.getId());

            retVal = "{\"userFacebookProfilePhotos\":[";
            for(int i = 0; i < userFacebookProfilePhotos.size(); i++){
                if(i != 0){
                    retVal += ",";
                }
                UserFacebookProfilePhoto ufpp = userFacebookProfilePhotos.get(i);
                retVal += "{";
                    retVal += "\"id\":\""+ufpp.getId()+"\",";
                    retVal += "\"ndwsUserId\":\""+ufpp.getNdwsUserId()+"\",";
                    retVal += "\"facebookProfilePhotoPath\":\""+ufpp.getFacebookProfilePhotoPath()+"\",";
                    retVal += "\"visibility\":\""+ufpp.getVisibility()+"\"";
                retVal += "}";
            }
            retVal += "]}";
        }catch(Exception e){
            e.printStackTrace();
        }

        return retVal;
    }

    @RequestMapping(value="/chooseFacebookPhotos", method = RequestMethod.GET)
    public ModelAndView goToChooseFacebookPhotos(ModelMap model){
        return new ModelAndView("chooseFacebookPhotos");
    }

    @RequestMapping(value="/saveFacebookProfilePhotos", method = RequestMethod.GET)
    public @ResponseBody
    String saveFacebookProfilePhotos(@RequestParam("fqlResponse") String fqlResponse) {
        try{
            JSONArray jsonArray  = (JSONArray)new JSONParser().parse(fqlResponse);
            saveAllUserFacebookProfilePhotos(jsonArray);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    public boolean saveAllUserFacebookProfilePhotos(JSONArray jsonArray) {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();

            com.NDWS.common.beans.User ndwsUser = null;
            try{
                AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
                UserRepository repository = context.getBean(UserRepository.class);
                ndwsUser = repository.findByEmailAddress(name);
                if(ndwsUser == null){
                    ndwsUser = new com.NDWS.common.beans.User();
                }
                UserFacebookProfilePhotoRepository userFacebookProfileRepository = context.getBean(UserFacebookProfilePhotoRepository.class);

                userFacebookProfileRepository.deleteAllFacebookProfilePhotosForUser(ndwsUser.getId());

                for(int i = 0; i < jsonArray.size(); i++){
                    String photoUrl = ((HashMap<String, String>)jsonArray.get(i)).get("src_big");
                    UserFacebookProfilePhoto userFacebookProfilePhoto = new UserFacebookProfilePhoto();
                    userFacebookProfilePhoto.setNdwsUserId(ndwsUser.getId());
                    userFacebookProfilePhoto.setFacebookProfilePhotoPath(photoUrl);
                    userFacebookProfileRepository.save(userFacebookProfilePhoto);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        return true;
    }
}

