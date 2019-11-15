package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.services.SearchService;
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
        return "searchhome";
    }
}
