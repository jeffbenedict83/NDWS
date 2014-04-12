package com.NDWS.common.controller;

import com.NDWS.BeanConfiguration;
import com.NDWS.common.beans.User;
import com.NDWS.common.beans.UserRole;
import com.NDWS.common.repositories.UserRepository;
import com.NDWS.common.repositories.UserRoleRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

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
    public ModelAndView addUser(@Valid @ModelAttribute("user")User user, BindingResult errors, ModelMap model) {
        if(errors.hasErrors()){
            return new ModelAndView("login");
        }else{
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
            UserRepository repository = context.getBean(UserRepository.class);
            User temp = repository.getByUsername(user.getUsername());
            if(temp != null){
                errors.rejectValue("username", "error.username", "Duplicate Username");
                return new ModelAndView("login");
            }

            try{
                String preShaPassword = user.getPassword();
                user.setPassword(sha(user.getPassword()));
                user.setConfirmPassword(sha(user.getConfirmPassword()));
                repository.save(user);

                user = repository.findByUsername(user.getUsername());

                UserRole userRole = new UserRole();
                userRole.setNdwsUserId(user.getId());
                userRole.setAuthority("ROLE_USER");
                UserRoleRepository userRoleRepository = context.getBean(UserRoleRepository.class);
                userRoleRepository.save(userRole);

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
                ArrayList<GrantedAuthority> grantedAuthorityArrayList = new ArrayList<GrantedAuthority>();
                grantedAuthorityArrayList.add(grantedAuthority);

                UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername (),preShaPassword,grantedAuthorityArrayList);

                Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,preShaPassword,grantedAuthorityArrayList);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }catch(Exception e){
                e.printStackTrace();
                return new ModelAndView("login");
            }
        }
        return new ModelAndView("landing");
    }

    public static String sha(String input) throws NoSuchAlgorithmException {
        String result = input;
        if(input != null) {
            MessageDigest md = MessageDigest.getInstance("SHA"); //or "SHA-1"
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }
}
