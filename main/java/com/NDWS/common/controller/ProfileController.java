package com.NDWS.common.controller;

import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserProfile;
import com.NDWS.persistence.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
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
public class ProfileController {
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView profileLanding(ModelMap model) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        model.addAttribute("error", "Invalid Login!");
        return new ModelAndView("profile", "userProfile", new UserProfile());

    }

    @RequestMapping(value = "/addOrUpdateUserProfile", method = RequestMethod.POST)
    public String addOrUpdateUserProfile(@Valid @ModelAttribute("userProfile")UserProfile userProfile, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return "login";
        }else{
            Session session = null;
            try{
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                session.save(userProfile);
                session.getTransaction().commit();
            }catch(ConstraintViolationException cve){
                //no need to print stacktrace, create error;
                return "profile";
            }catch(Exception e){
                e.printStackTrace();
                //something bad happened.
                errors.rejectValue("firstName", "error.firstName", "An error occured while saving your user profile!");
                if(session != null){
                    session.getTransaction().rollback();
                }
                return "profile";
            }finally{
                if(session != null){
                    //session.close();
                }
            }
        }
        return "landing";
    }

}


