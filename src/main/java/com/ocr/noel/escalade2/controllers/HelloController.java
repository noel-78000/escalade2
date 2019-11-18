package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Address;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.enums.RoleEnum;
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
//import org.springframework.validation.Validator;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HelloController {

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
        User user1 = new User();
        user1.setEmail("aaaa");
        user1.setPhonenumber("bbbbb");
        boolean error = validateService.validate(modelMap, user1);

        System.out.println("error: " + error);


        /*The if code below is just for test : have to be delete in the future*/
        if (nom != null) {
            User userTemp = new User();
            userTemp.setLastName(nom);
            userTemp.setFirstName(prenom);
            userTemp.setEmail("user@yahoo.fr");
            userTemp.setPwd("1234");
            userTemp.setRole(RoleEnum.ROLE_USER.getNum());
            Address address = new Address();
            address.setCity("paris");
            address.setAddress("3 rue Leclerc");
            address.setCountry("FRANCE");
            address.setZipcode("75002");
            userTemp.setAddress(address);
            userService.save(userTemp);
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

    @RequestMapping(value = "appExceptionHandler")
    public String appExceptionHandler(HttpServletRequest request, ModelMap modelMap) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        modelMap.addAttribute("message", String.format("Houps... page non disponible! code: %d", statusCode));
        return "hello";
    }

}
