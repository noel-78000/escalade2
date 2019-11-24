package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.TopoService;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/personnalspace")
public class PersonnalSpaceController {

    @Autowired
    UserService userService;

    @Autowired
    TopoService topoService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Principal principal,
                       ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        modelMap.addAttribute("user", user);
        return "personnalspacehome";
    }

    @RequestMapping(value = "/topo/add", method = RequestMethod.GET)
    public String addNewTopo(Principal principal,
                             ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        modelMap.addAttribute("userid", user.getId());
        return "addtopo";
    }

    @RequestMapping(value = "/topo/add", method = RequestMethod.POST)
    public String addTopo(@RequestParam("userid") Integer userId,
                          @RequestParam("lieu") String lieu,
                          @RequestParam("description") String description,
                          @RequestParam(value = "topopret", required = false) String topoPret,
                          ModelMap modelMap) {
        boolean isOK = topoService.add(userId, lieu, description, topoPret);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("userid", userId);
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "addtopo";
        }
    }
}
