package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(@RequestParam(required = true) String id,
                          Principal principal, ModelMap modelMap) {
        return "";
    }
}
