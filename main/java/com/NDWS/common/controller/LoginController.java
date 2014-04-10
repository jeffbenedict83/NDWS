package com.NDWS.common.controller;

import com.NDWS.common.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: jeffreyb08
 * Date: 4/5/14
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LoginController {
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        return new ModelAndView("login", "user", new User());
    }

    @RequestMapping(value="/loginFailed", method = RequestMethod.GET)
    public ModelAndView loginerror(ModelMap model) {

        model.addAttribute("error", "Invalid Login!");
        return new ModelAndView("login", "user", new User());

    }

    @RequestMapping(value="/loginDirect", method = RequestMethod.GET)
    public ModelAndView loginDirect(ModelMap model) {
        return new ModelAndView("login", "user", new User());
    }

    /*@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "mainLanding";

    }*/
}
