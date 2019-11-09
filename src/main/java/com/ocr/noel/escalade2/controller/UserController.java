package com.ocr.noel.escalade2.controller;

import com.ocr.noel.escalade2.entity.User;
import com.ocr.noel.escalade2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
