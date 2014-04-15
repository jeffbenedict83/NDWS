package com.NDWS.common.controller;

import com.NDWS.common.beans.UserProfile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/6/14
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {
    @RequestMapping(value="/landing", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        model.addAttribute("username", name);
        model.addAttribute("message", "Spring Security login + database example");
        return "landing";

    }

    /*@RequestMapping(value="/", method = RequestMethod.GET)
    public String mainLanding(ModelMap model) {
        return "mainLanding";

    }*/
}

