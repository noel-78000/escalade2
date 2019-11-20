package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Secteur;
import com.ocr.noel.escalade2.services.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secteur")
public class SecteurController {

    @Autowired
    SecteurService secteurService;

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String seeAttributes(@RequestParam("id") Integer id,
                      @RequestParam("siteid") Integer siteId,
                      ModelMap modelMap) {
        Secteur secteur = secteurService.findById(id);
        modelMap.addAttribute("secteur", secteur);
        modelMap.addAttribute("siteid", siteId);
        return "secteurchange";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributes(@RequestParam(value = "id") Integer id,
                             @RequestParam(value = "siteid") Integer siteId,
                             @RequestParam(value = "nom") String nom,
                             ModelMap modelMap) {
        boolean isOK = secteurService.updateSecteur(id, nom);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", "Erreur de saisie");
            modelMap.addAttribute("secteur", secteurService.findById(id));
            modelMap.addAttribute("siteid", siteId);
            return "secteurchange";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam(value = "siteid") Integer siteId,
                      @RequestParam(value = "nom") String nom,
                      ModelMap modelMap) {
        boolean isOK = secteurService.add(nom, siteId);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + siteId;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("errorsecteur", "Erreur de saisie de secteur");
            modelMap.addAttribute("siteid", siteId);
            return "sitechange";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "siteid") Integer siteId,
                         ModelMap modelMap) {
        secteurService.deleteById(id);
        String redirectUrl = "/site/details?id=" + siteId;
        return "redirect:" + redirectUrl;
    }
}
