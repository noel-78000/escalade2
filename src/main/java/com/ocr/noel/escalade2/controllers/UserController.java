package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "/listpage")
    public String test(@RequestParam(value = "num", required = false, defaultValue = "0") Integer numPage,
                       ModelMap modelMap) {
        Page<User> userPage = userService.getPageableSorted(numPage, 5);
        modelMap.addAttribute("userPage", userPage);
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
        Map<String, String> map = userService.setNewUser(email, password, passwordconfirm, firstname, lastname);
        if (map.size() == 1 && !map.containsKey("error")) {
            modelMap.addAllAttributes(map);
            authWithHttpServletRequest(request, email, password);
            return "home";
        }
        modelMap.addAllAttributes(map);
        return "registeruser";
    }

    @RequestMapping(value = "/moncompte", method = RequestMethod.GET)
    public String monCompte(Principal principal, ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        Map<String, String> mapCompte = userService.getMapFormMonCompte(user);
        modelMap.addAllAttributes(mapCompte);
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
        User user = userService.getUserFromPrincipalAndDB(principal);
        Map<String, String> map = userService.updateUserInformation(email, password, passwordconfirm, firstname, lastname,
                phonenumber, address, city, zipcode, country, user);
        modelMap.addAllAttributes(map);
        if (!map.containsKey("errorOccurred")) {
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
