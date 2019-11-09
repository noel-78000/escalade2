package com.ocr.noel.escalade2.controller;

import com.ocr.noel.escalade2.entity.Address;
import com.ocr.noel.escalade2.entity.User;
import com.ocr.noel.escalade2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserService userService;
    /*@RequestMapping("")
    @ResponseBody
    String get(){
        return "this is a return plain text";
    }*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestParam(required = false) String nom,
                        @RequestParam(required = false) String prenom,
                        ModelMap modelMap) {
        /*The if code below is just for test : have to be delete in the future*/
        if (nom != null) {
            User user = new User();
            user.setLastName(nom);
            user.setFirstName(prenom);
            Address address = new Address();
            address.setCity("paris");
            address.setAddress("2 rue du mal de lattre de tassigny");
            address.setCountry("FRANCE");
            address.setZipcode("75001");
            user.setAddress(address);
            userService.save(user);
        }
        modelMap.addAttribute("message", "Hello spring mvc framework 1");
        return "hello";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String printHello2(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello spring mvc framework 2");
        return "hello";
    }

}
