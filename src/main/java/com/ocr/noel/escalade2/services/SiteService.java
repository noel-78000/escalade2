package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Secteur;
import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.entities.Voie;
import com.ocr.noel.escalade2.enums.RoleEnum;
import com.ocr.noel.escalade2.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    SecteurService secteurService;

    @Autowired
    UserService userService;

    @Autowired
    VoieService voieService;

    public Site findByIdFetchSecteurs(Integer id) {
        return siteRepository.findByIdFetchSecteurs(id).orElse(null);
    }

    public Site findByIdFetchSecteursFetchVoiesFetchLongueurs(Integer id) {
        Site site = siteRepository.findByIdFetchSecteurs(id).orElse(null);
        if (site != null) {
            List<Secteur> secteurs = new ArrayList<>();
            site.getSecteurs().forEach(s -> {
                Secteur secteur = secteurService.findByIdFetchVoiesFetchLongueurs(s.getId());
                if (secteur != null) {
                    secteurs.add(secteur);
                }
            });
            site.setSecteurs(secteurs);
        }
        return site;
    }

    public Site findById(Integer id) {
        return siteRepository.findById(id).orElse(null);
    }

    public List<Site> findByIdFetchSecteursCountSecteur(Integer count) {
        return siteRepository.findByIdFetchSecteursCountSecteur(count);
    }

    public List<Site> findStartWithLieu(String lieu) {
        return siteRepository.findStartWithLieu(lieu);
    }

    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    @Transactional
    public void deleteById(Integer id) {
        siteRepository.deleteById(id);
    }

    @Transactional
    public void delete(Site site) {
        siteRepository.delete(site);
    }

    @Transactional
    public void save(Site site) {
        siteRepository.save(site);
    }

    @Transactional
    public boolean updateSite(Integer id, String lieu, String nom, String tag, Principal principal) {
        Site site = findById(id);
        if (site == null) {
            return false;
        }
        if (lieu != null && lieu.length() > 0 && lieu.length() <= 100) site.setLieu(lieu);
        if (nom != null && nom.length() > 0 && nom.length() <= 100) site.setNom(nom);
        boolean isAtAssoLevel = userService.isAtLeastAssociationLevel(principal);
        if (isAtAssoLevel) {
            if (tag == null) site.setTag(false);
            else site.setTag(true);
        }
        save(site);
        return true;
    }

    @Transactional
    public Site add(String lieu, String nom, String siteOfficialTag, Principal principal) {
        if (lieu != null && lieu.length() > 0 && lieu.length() <= 100
            && nom != null && nom.length() > 0 && nom.length() <= 100) {
            Site site = new Site();
            site.setLieu(lieu);
            site.setNom(nom);
            boolean isAtAssoLevel = userService.isAtLeastAssociationLevel(principal);
            if (isAtAssoLevel) {
                if (siteOfficialTag == null) site.setTag(false);
                else site.setTag(true);
            } else {
                site.setTag(false);
            }
            Site siteSaved = siteRepository.save(site);
            return siteSaved;
        }
        return null;
    }
}
