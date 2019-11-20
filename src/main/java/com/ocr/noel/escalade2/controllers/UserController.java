package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "/list")
    public String list(ModelMap modelMap) {
        List<User> userList = userService.findAllUser();
        modelMap.addAttribute("userList", userList);
        return "listuser";
    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.GET)
    public String registeruser(ModelMap modelMap) {
        return "registeruser";
    }

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    public String newuser(@RequestParam(required = true) String email,
                          @RequestParam(required = true) String password,
                          @RequestParam(required = true) String passwordconfirm,
                          @RequestParam(required = true) String firstname,
                          @RequestParam(required = true) String lastname,
                          HttpServletRequest request,
                          ModelMap modelMap) {
        boolean isRegistered = userService.setNewUser(email, password, passwordconfirm, firstname, lastname, modelMap);
        if (isRegistered) {
            authWithHttpServletRequest(request, email, password);
            return "home";
        }
        return "registeruser";
    }

    @RequestMapping(value = "/moncompte", method = RequestMethod.GET)
    public String monCompte(Principal principal, ModelMap modelMap) {
        userService.getHtmlFormMonCompte(principal, modelMap);
        return "moncompte";
    }

    @RequestMapping(value = "/moncompte", method = RequestMethod.POST)
    public String monCompteRenew(@RequestParam(required = true) String email,
                                 @RequestParam(required = false) String password,
                                 @RequestParam(required = false) String passwordconfirm,
                                 @RequestParam(required = false) String firstname,
                                 @RequestParam(required = false) String lastname,
                                 @RequestParam(required = false) String phonenumber,
                                 @RequestParam(required = false) String address,
                                 @RequestParam(required = false) String city,
                                 @RequestParam(required = false) String zipcode,
                                 @RequestParam(required = false) String country,
                                 Principal principal, ModelMap modelMap) {
        boolean registrationOK = userService.updateUserInformation(email, password, passwordconfirm, firstname, lastname,
                phonenumber, address, city, zipcode, country, principal, modelMap);
        if (registrationOK) {
            modelMap.addAttribute("message", messageSourceService.getMessage("registration.ok"));
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("registration.nok"));
        }
        return "moncompte";
    }

    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
        }
    }
}
