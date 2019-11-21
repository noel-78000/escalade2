package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String details(@RequestParam(required = true) Integer id, ModelMap modelMap) {
        Site site = siteService.findByIdFetchSecteursFetchVoiesFetchLongueurs(id);
        if (site != null) {
            modelMap.addAttribute("site", site);
        }
        return "sitedetails";
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String seeAttributes(@RequestParam("id") Integer id, ModelMap modelMap) {
        Site site = siteService.findById(id);
        modelMap.addAttribute("site", site);
        return "sitechange";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributes(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "lieu") String lieu,
                                   @RequestParam(value = "nom") String nom,
                                   HttpServletRequest request,
                                   ModelMap modelMap) {
        boolean isOK = siteService.updateSite(id, lieu, nom);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + id;
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.tying"));
            return "sitechange";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "addnewsite";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNew(@RequestParam(value = "lieu") String lieu,
                         @RequestParam(value = "nom") String nom,
                         HttpServletRequest request,
                         ModelMap modelMap) {
        Site site = siteService.add(lieu, nom);
        if (site != null) {
            String redirectUrl = "/site/details?id=" + site.getId();
            return "redirect:" + redirectUrl;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error.create.site"));
            return "addnewsite";
        }
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String addNew(@RequestParam(value = "id") Integer id, ModelMap modelMap) {
        siteService.deleteById(id);
        List<Site> sites = siteService.findAll();
        modelMap.addAttribute("sitessommaire", sites);
        return "searchhome";
    }
}
