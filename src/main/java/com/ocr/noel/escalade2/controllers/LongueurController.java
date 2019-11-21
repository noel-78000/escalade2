package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Longueur;
import com.ocr.noel.escalade2.entities.Voie;
import com.ocr.noel.escalade2.services.LongueurService;
import com.ocr.noel.escalade2.services.MessageSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/longueur")
public class LongueurController {

    @Autowired
    LongueurService longueurService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String seeAttributes(@RequestParam("id") Integer id,
                                @RequestParam("siteid") Integer siteId,
                                ModelMap modelMap) {
        Longueur longueur = longueurService.findById(id);
        modelMap.addAttribute("longueur", longueur);
        modelMap.addAttribute("siteid", siteId);
        return "longueurchange";
    }


    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributes(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "siteid") Integer siteId,
                                   @RequestParam(value = "cotation") String cotation,
                                   ModelMap modelMap) {
        boolean isOK = longueurService.updateLongueur(id, cotation);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.tying"));
            modelMap.addAttribute("longueur", longueurService.findById(id));
            modelMap.addAttribute("siteid", siteId);
            return "longueurchange";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "siteid") Integer siteId,
                         ModelMap modelMap) {
        longueurService.deleteById(id);
        String redirectUrl = "/site/details?id=" + siteId;
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNew(@RequestParam(value = "siteid") Integer siteId,
                         @RequestParam(value = "id") Integer voieId,
                         ModelMap modelMap) {
        modelMap.addAttribute("siteid", siteId);
        modelMap.addAttribute("voieid", voieId);
        return "addnewlongueur";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "siteid") Integer siteId,
                      @RequestParam(value = "voieid") Integer voieId,
                      @RequestParam(value = "cotation") String cotation,
                      ModelMap modelMap) {
        boolean isOK = longueurService.add(cotation, voieId);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.longueur.tying"));
            modelMap.addAttribute("siteid", siteId);
            modelMap.addAttribute("voieid", voieId);
            return "addnewlongueur";
        }
    }
}
