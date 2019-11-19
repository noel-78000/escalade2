package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(@RequestParam(required = true) Integer id, ModelMap modelMap) {
        Site site = siteService.findByIdFetchSecteursFetchVoiesFetchLongueurs(id);
        if (site != null) {
            modelMap.addAttribute("site", site);
        }
        return "sitedetails";
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String seeAttibuts(@RequestParam("id") Integer id, ModelMap modelMap) {
        Site site = siteService.findById(id);
        modelMap.addAttribute("site", site);
        return "sitechange";
    }
    // lieu nom
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributs(@RequestParam(value = "id", required = true) Integer id,
                                  @RequestParam(value = "lieu", required = true) String lieu,
                                  @RequestParam(value = "nom", required = true) String nom,
                                  HttpServletRequest request,
                                  ModelMap modelMap) {
        boolean isOK = siteService.updateSite(id, lieu, nom);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + id;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", "Erreur de saisie");
            return "sitechange";
        }

    }

}
