package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.SearchService;
import com.ocr.noel.escalade2.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @Autowired
    SiteService siteService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String searchHomePage() {
        return "searchhome";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String search(@RequestParam(required = false) String lieu,
                         @RequestParam(required = false) String nombredesecteurs,
                         @RequestParam(required = false) String cotation,
                         ModelMap modelMap) {
        List<Site> sites = searchService.search(lieu, nombredesecteurs, cotation);
        modelMap.addAttribute("sites", sites);
        if (sites.size() == 0) modelMap.addAttribute("rechercheinfructueuse", messageSourceService.getMessage("recherche.infructueuse"));
        return "searchhome";
    }

    @RequestMapping(value = "listsites", method = RequestMethod.GET)
    public String listSites(ModelMap modelMap) {
        List<Site> sites = siteService.findAll();
        modelMap.addAttribute("sites", sites);
        return "searchsites";
    }

    @RequestMapping(value = "site", method = RequestMethod.GET)
    public String site(@RequestParam Integer id, ModelMap modelMap) {
        Site site = siteService.findByIdFetchSecteursFetchVoiesFetchLongueurs(id);
        modelMap.addAttribute("site", site);
        return "searchsites";
    }
}
