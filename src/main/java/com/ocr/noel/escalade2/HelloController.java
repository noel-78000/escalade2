package com.ocr.noel.escalade2;

import com.ocr.noel.escalade2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    UserRepository userRepository;
    /*@RequestMapping("")
    @ResponseBody
    String get(){
        return "this is a return plain text";
    }*/

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String printHello(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello spring mvc framework 1");
        return "hello";
    }
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String printHello2(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello spring mvc framework 2");
        return "hello";
    }
}
