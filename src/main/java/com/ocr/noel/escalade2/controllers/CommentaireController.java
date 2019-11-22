package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.entities.Commentaire;
import com.ocr.noel.escalade2.services.CommentaireService;
import com.ocr.noel.escalade2.services.MessageSourceService;
import com.ocr.noel.escalade2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageSourceService messageSourceService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam("id") Integer siteId,
                       ModelMap modelMap,
                       Principal principal) {
        List<Commentaire> commentaires = commentaireService.findAllBySiteIdFetchUser(siteId);
        modelMap.addAttribute("commentaires", commentaires);
        boolean isAssoLevel = userService.isAtLeastAssociationLevel(principal);
        modelMap.addAttribute("isassolevel", isAssoLevel);
        modelMap.addAttribute("siteid", siteId);
        return "commentlist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNew(@RequestParam("siteid") Integer siteId,
                         ModelMap modelMap) {
        modelMap.addAttribute("siteid", siteId);
        return "commentnew";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("siteid") Integer siteId,
                      @RequestParam("commentnew") String comment,
                      ModelMap modelMap,
                      Principal principal) {
        boolean isOK = commentaireService.addNew(comment, siteId, principal);
        if (isOK) {
            String url = "/comment/list?id=" + siteId;
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("siteid", siteId);
            return "commentnew";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer commentId,
                         @RequestParam("siteid") Integer siteId,
                         Principal principal) {
        commentaireService.delete(commentId, principal);
        String url = "/comment/list?id=" + siteId;
        return "redirect:" + url;
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String change(@RequestParam("id") Integer commentId,
                         @RequestParam("siteid") Integer siteId,
                         Principal principal,
                         ModelMap modelMap) {
        boolean isAtLestAssoLevel = userService.isAtLeastAssociationLevel(principal);
        if (isAtLestAssoLevel) {
            Commentaire comment = commentaireService.findByIdFetchSiteFetchUser(commentId);
            modelMap.addAttribute("comment", comment);
            return "commentchange";
        } else {
            String url = "/comment/list?id=" + siteId;
            return "redirect:" + url;
        }
    }

    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public String changeComment(@RequestParam("siteid") Integer siteId,
                                @RequestParam("commentid") Integer commentId,
                                @RequestParam("commentchange") String comment,
                                ModelMap modelMap,
                                Principal principal) {
        boolean isOK = commentaireService.change(comment, commentId, principal);
        if (isOK) {
            String url = "/comment/list?id=" + siteId;
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "commentchange";
        }
    }
}
