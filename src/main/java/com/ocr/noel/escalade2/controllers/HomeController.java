package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.SiteService;
import com.ocr.noel.escalade2.services.UserService;
import com.ocr.noel.escalade2.services.ValidateObjectService;
import com.ocr.noel.escalade2.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;
import java.security.Principal;

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
    public String index(@RequestParam(required = false) String nom,
                        @RequestParam(required = false) String prenom,
                        ModelMap modelMap,
                        Principal principal) {
        User user = UserUtil.getUserFromPrincipal(principal);
        modelMap.addAttribute("message", "Hello spring mvc framework 1");
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("message", "in login form");
        return "login";
    }

    @RequestMapping(value = "appExceptionHandler")
    public String appExceptionHandler(HttpServletRequest request, ModelMap modelMap) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        modelMap.addAttribute("message", String.format("Houps... page non disponible! code: %d", statusCode));
        return "home";
    }

}
