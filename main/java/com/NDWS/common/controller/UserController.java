package com.NDWS.common.controller;

import com.NDWS.common.beans.User;
import com.NDWS.persistence.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.hibernate.exception.ConstraintViolationException;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("mainLanding", "user", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("user")User user, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return "login";
        }else{
            Session session = null;
            try{
                session = HibernateUtil.getSessionFactory().getCurrentSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
            }catch(ConstraintViolationException cve){
                //no need to print stacktrace, create error;
                //add error for non unique username
                errors.rejectValue("username", "error.username", "Duplicate Username");
                model.addAttribute("openSignup", "1");
                if(session != null){
                    session.getTransaction().rollback();
                }
                return "login";
            }catch(Exception e){
                e.printStackTrace();
                //something bad happened.
                errors.rejectValue("username", "error.username", "An error occured while creating your user!");
                if(session != null){
                    session.getTransaction().rollback();
                }
                return "login";
            }finally{
                if(session != null){
                    //session.close();
                }
            }
        }
        return "landing";
    }
}
