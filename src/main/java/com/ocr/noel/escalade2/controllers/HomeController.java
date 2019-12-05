package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.services.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", messageSourceService.getMessage("welcome"));
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "appExceptionHandler")
    public String appExceptionHandler(HttpServletRequest request, ModelMap modelMap) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        modelMap.addAttribute("message", String.format(messageSourceService.getMessage("error.page"), statusCode));
        return "home";
    }
}
