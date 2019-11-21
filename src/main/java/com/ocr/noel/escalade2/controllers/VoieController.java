package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Voie;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/voie")
public class VoieController {

    @Autowired
    VoieService voieService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String seeAttributes(@RequestParam("id") Integer id,
                                @RequestParam("siteid") Integer siteId,
                                ModelMap modelMap) {
        Voie voie = voieService.findById(id);
        modelMap.addAttribute("voie", voie);
        modelMap.addAttribute("siteid", siteId);
        return "voiechange";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributes(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "siteid") Integer siteId,
                                   @RequestParam(value = "nom") String nom,
                                   ModelMap modelMap) {
        boolean isOK = voieService.updateVoie(id, nom);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.tying"));
            modelMap.addAttribute("voie", voieService.findById(id));
            modelMap.addAttribute("siteid", siteId);
            return "voiechange";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "siteid") Integer siteId,
                         ModelMap modelMap) {
        voieService.deleteById(id);
        String redirectUrl = "/site/details?id=" + siteId;
        return "redirect:" + redirectUrl;

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNew(@RequestParam(value = "siteid") Integer siteId,
                         @RequestParam(value = "id") Integer secteurId,
                         ModelMap modelMap) {
        modelMap.addAttribute("siteid", siteId);
        modelMap.addAttribute("secteurid", secteurId);
        return "addnewvoie";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "siteid") Integer siteId,
                      @RequestParam(value = "secteurid") Integer secteurId,
                      @RequestParam(value = "nom") String nom,
                      ModelMap modelMap) {
        boolean isOK = voieService.add(nom, secteurId);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.voie.tying"));
            modelMap.addAttribute("siteid", siteId);
            modelMap.addAttribute("secteurid", secteurId);
            return "addnewvoie";
        }
    }
}
