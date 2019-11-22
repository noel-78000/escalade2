package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.SiteService;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

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
    public String seeAttributes(@RequestParam("id") Integer id,
                                ModelMap modelMap,
                                Principal principal) {
        boolean isAssoLevel = userService.isAtLeastAssociationLevel(principal);
        modelMap.addAttribute("isassolevel", isAssoLevel);
        Site site = siteService.findById(id);
        modelMap.addAttribute("site", site);
        if (site.getTag()) {
            modelMap.addAttribute("siteofficialistaged", true);
        }
        return "sitechange";
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeAttributes(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "lieu") String lieu,
                                   @RequestParam(value = "nom") String nom,
                                   @RequestParam(value = "siteofficial", required = false) String siteOfficialTag,
                                   HttpServletRequest request,
                                   ModelMap modelMap,
                                   Principal principal
                                   ) {
        boolean isOK = siteService.updateSite(id, lieu, nom, siteOfficialTag, principal);
        if (isOK) {
            String redirectUrl = "/site/details?id=" + id;
            return "redirect:" + redirectUrl;
        } else {
            boolean isAssoLevel = userService.isAtLeastAssociationLevel(principal);
            modelMap.addAttribute("isassolevel", isAssoLevel);
            modelMap.addAttribute("error", messageSourceService.getMessage("error.tying"));
            if (siteOfficialTag != null ) {
                modelMap.addAttribute("siteofficialistaged", true);
            }
            return "sitechange";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap modelMap, Principal principal) {
        boolean isAssoLevel = userService.isAtLeastAssociationLevel(principal);
        modelMap.addAttribute("isassolevel", isAssoLevel);
        return "addnewsite";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNew(@RequestParam(value = "lieu") String lieu,
                         @RequestParam(value = "nom") String nom,
                         @RequestParam(value = "siteofficial", required = false) String siteOfficialTag,
                         HttpServletRequest request,
                         ModelMap modelMap,
                         Principal principal) {
        Site site = siteService.add(lieu, nom, siteOfficialTag, principal);
        if (site != null) {
            String redirectUrl = "/site/details?id=" + site.getId();
            return "redirect:" + redirectUrl;
        } else {
            boolean isAssoLevel = userService.isAtLeastAssociationLevel(principal);
            modelMap.addAttribute("isassolevel", isAssoLevel);
            modelMap.addAttribute("error", messageSourceService.getMessage("error.create.site"));
            return "addnewsite";
        }
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String addNew(@RequestParam(value = "id") Integer id,
                         ModelMap modelMap,
                         Principal principal) {
        siteService.deleteById(id, principal);
        List<Site> sites = siteService.findAll();
        modelMap.addAttribute("sitessommaire", sites);
        return "searchhome";
    }
}
