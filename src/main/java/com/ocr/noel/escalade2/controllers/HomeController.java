package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.services.SiteService;
import com.ocr.noel.escalade2.services.UserService;
import com.ocr.noel.escalade2.services.ValidateObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    SiteService siteService;

    @Autowired
    Validator validator;

    @Autowired
    ValidateObjectService validateService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello amis de l'escalade");
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "appExceptionHandler")
    public String appExceptionHandler(HttpServletRequest request, ModelMap modelMap) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        modelMap.addAttribute("message", String.format("Houps... page non disponible! code: %d", statusCode));
        return "home";
    }

}
