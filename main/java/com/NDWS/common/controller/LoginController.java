package com.NDWS.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String login(ModelMap model) {

        return "landing";

    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        return "mainLanding";

    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {

        return "mainLanding";

    }
}
