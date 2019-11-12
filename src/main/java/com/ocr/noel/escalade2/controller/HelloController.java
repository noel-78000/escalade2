package com.ocr.noel.escalade2.controller;

import com.ocr.noel.escalade2.entity.Address;
import com.ocr.noel.escalade2.entity.User;
import com.ocr.noel.escalade2.service.MyUserPrincipal;
import com.ocr.noel.escalade2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestParam(required = false) String nom,
                        @RequestParam(required = false) String prenom,
                        ModelMap modelMap,
                        Principal principal) {
        if (principal != null) {
            User userDB = ((MyUserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
            System.out.println(userDB.getEmail() + ", " + userDB.getPwd() + ", " + userDB.getAddress().getId());
        }
        /*The if code below is just for test : have to be delete in the future*/
        if (nom != null) {
            User user = new User();
            user.setLastName(nom);
            user.setFirstName(prenom);
            user.setEmail("noel@yahoo.fr");
            user.setPwd("1234");
            Address address = new Address();
            address.setCity("paris");
            address.setAddress("2 rue du mal de lattre de tassigny");
            address.setCountry("FRANCE");
            address.setZipcode("75001");
            user.setAddress(address);
            userService.save(user);
        }
        modelMap.addAttribute("message", "Hello spring mvc framework 1");
        return "hello";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String printHello2(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello spring mvc framework 2");
        return "hello";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("message", "in logind form");
        return "login";
    }

}
