package com.NDWS.common.controller;

import com.NDWS.common.beans.NewUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/7/14
 * Time: 8:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class NewUserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView student() {
        return new ModelAndView("mainLanding", "newUser", new NewUser());
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute("newUser")NewUser newUser, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return "mainLanding";
        }
        return "landing";
    }
}
