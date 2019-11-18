package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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

    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
        }
    }
}
