package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.enums.RoleEnum;
import com.ocr.noel.escalade2.services.UserService;
import com.ocr.noel.escalade2.services.ValidateObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    ValidateObjectService validateObjectService;

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
                          HttpServletRequest request,
                          ModelMap modelMap) {
        User userExist = userService.findByEmail(email);
        if (userExist != null) {
            return "registeruser";
        }
        User user = new User();
        user.setEmail(email);
        user.setRole(RoleEnum.ROLE_USER.getNum());
        if (password != null && password.equals(passwordconfirm)) {
            user.setPwd(password);
        }
        boolean error = validateObjectService.validate(modelMap, user);
        if (!error) {
            userService.save(user);
            authWithHttpServletRequest(request, email, password);
            modelMap.addAttribute("message", "login reussi");
            return "hello";
        }
        return "registeruser";
    }

    public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            //LOGGER.error("Error while login ", e);
        }
    }
}
