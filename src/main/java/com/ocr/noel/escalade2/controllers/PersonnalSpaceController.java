package com.ocr.noel.escalade2.controllers;

import com.ocr.noel.escalade2.beans.TopoInfo;
import com.ocr.noel.escalade2.entities.Topo;
import com.ocr.noel.escalade2.entities.TopoResa;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/personnalspace")
public class PersonnalSpaceController {

    @Autowired
    UserService userService;

    @Autowired
    TopoService topoService;

    @Autowired
    TopoInfoService topoInfoService;

    @Autowired
    TopoResaService topoResaService;

    @Autowired
    MessageSourceService messageSourceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(Principal principal,
                       ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        modelMap.addAttribute("user", user);
        List<TopoInfo> topoInfos = topoInfoService.findAllByUserId(user);
        modelMap.addAttribute("topoinfos", topoInfos);
        return "personnalspacehome";
    }

    @RequestMapping(value = "/topo/add", method = RequestMethod.GET)
    public String addNewTopo(Principal principal,
                             ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        modelMap.addAttribute("userid", user.getId());
        return "addtopo";
    }

    @RequestMapping(value = "/topo/add", method = RequestMethod.POST)
    public String addTopo(@RequestParam("lieu") String lieu,
                          @RequestParam("description") String description,
                          @RequestParam(value = "topopret", required = false) String topoPret,
                          Principal principal,
                          ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        boolean isOK = topoService.add(user, lieu, description, topoPret);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "addtopo";
        }
    }

    @RequestMapping(value = "/topo/change", method = RequestMethod.GET)
    public String viewTopo(@RequestParam("topoid") Integer topoId,
                           Principal principal,
                           ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        Topo topo = topoService.getTopo(topoId, user);
        modelMap.addAttribute("topo", topo);
        return "changetopo";
    }

    @RequestMapping(value = "/topo/change", method = RequestMethod.POST)
    public String changeTopo(@RequestParam("topoid") Integer topoId,
                             @RequestParam("lieu") String lieu,
                             @RequestParam("description") String description,
                             @RequestParam(value = "topopret", required = false) String topoPret,
                             Principal principal,
                             ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        boolean isOK = topoService.updateTopo(topoId, lieu, description, topoPret, user);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            Topo topo = topoService.getTopo(topoId, user);
            modelMap.addAttribute("topo", topo);
            return "changetopo";
        }
    }

    @RequestMapping(value = "/topo/delete", method = RequestMethod.POST)
    public String delteTopo(@RequestParam("topoid") Integer topoId,
                            Principal principal,
                            ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        boolean isOK = topoService.deleteTopo(topoId, user);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            Topo topo = topoService.getTopo(topoId, user);
            modelMap.addAttribute("topo", topo);
            return "changetopo";
        }
    }

    @RequestMapping(value = "/topo/list", method = RequestMethod.GET)
    public String listTopo(Principal principal,
                           ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        List<Topo> topos = topoService.findAllDispoWithoutUserIdWithoutResa(user.getId());
        modelMap.addAttribute("topos", topos);
        return "listtopodispo";
    }

    @RequestMapping(value = "/topo/resa", method = RequestMethod.POST)
    public String toporesa(@RequestParam("topoid") Integer topoId,
                           Principal principal,
                           ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        boolean isOK = topoResaService.addResa(topoId, user);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "listtopodispo";
        }
    }

    @RequestMapping(value = "/toporesa/selected", method = RequestMethod.GET)
    public String topoResaInfo(@RequestParam("toporesaid") Integer topoResaId,
                               ModelMap modelMap) {
        TopoResa topoResa = topoResaService.findByIdFetchUserFetchTopo(topoResaId);
        if (topoResa == null) {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
        }
        modelMap.addAttribute("toporesa", topoResa);
        return "toporesa";
    }

    @RequestMapping(value = "/toporesa/selected", method = RequestMethod.POST)
    public String topoResaSelected(@RequestParam("toporesaid") Integer topoResaId,
                                   @RequestParam(value = "acceptresa", required = false) String acceptResa,
                                   ModelMap modelMap) {
        boolean isOK = topoResaService.setUpResa(topoResaId, acceptResa);
        if (isOK) {
            String url = "/personnalspace";
            return "redirect:" + url;
        } else {
            TopoResa topoResa = topoResaService.findByIdFetchUserFetchTopo(topoResaId);
            modelMap.addAttribute("toporesa", topoResa);
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "toporesa";
        }
    }

    @RequestMapping(value = "/topo/myresas", method = RequestMethod.GET)
    public String myResa(Principal principal,
                         ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        List<TopoResa> topoResas = topoResaService.getForUserFetchTopoFetchUserTopo(user);
        modelMap.addAttribute("toporesas", topoResas);
        return "myresalist";
    }

    @RequestMapping(value = "/toporesa/delete", method = RequestMethod.POST)
    public String deleteResa(@RequestParam("toporesaid") Integer topoResaId,
                             Principal principal,
                             ModelMap modelMap) {
        User user = userService.getUserFromPrincipalAndDB(principal);
        boolean isOK = topoResaService.delete(topoResaId, user);
        List<TopoResa> topoResas = topoResaService.getForUserFetchTopoFetchUserTopo(user);
        modelMap.addAttribute("toporesas", topoResas);
        if (isOK) {
            return "myresalist";
        } else {
            modelMap.addAttribute("error", messageSourceService.getMessage("error"));
            return "myresalist";
        }
    }
}
