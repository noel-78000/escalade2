package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Longueur;
import com.ocr.noel.escalade2.entities.Secteur;
import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.entities.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class SearchService {

    @Autowired
    LongueurService longueurService;

    @Autowired
    VoieService voieService;

    @Autowired
    SecteurService secteurService;

    @Autowired
    SiteService siteService;

    public List<Site> search(String lieu, String nombredesecteurs, String cotation) {
        List<Site> sites = new ArrayList<>();
        if (cotation != null) {
            List<Longueur> longueurs = longueurService.findStartWithCotation(cotation);
            longueurs.forEach(longueur -> {
                Site site = findSiteForLongueur(longueur);
                if (site != null && !sites.contains(site)) {
                    sites.add(site);
                } else if (site != null && sites.contains(site)) {
                    addNewComponentInSite(sites, site);
                }
            });
        }
        //TODO
        return sites;
    }

    /**
     * Met à jour le site dans la liste des site
     *
     * @param sites la liste des sites existant
     * @param site  le nouveau site à mettre à jour
     */
    private void addNewComponentInSite(List<Site> sites, Site site) {
        AtomicBoolean siteAdded = new AtomicBoolean(false);
        sites.forEach(s -> {
            if (site.equals(s)) {
                siteAdded.set(true);
                site.getSecteurs().forEach(newSecteur -> {
                    AtomicBoolean secteurAdded = new AtomicBoolean(false);
                    s.getSecteurs().forEach(secteurList -> {
                        if (newSecteur.equals(secteurList)) {
                            secteurAdded.set(true);


                            AtomicBoolean voieAdded = new AtomicBoolean(false);
                            newSecteur.getVoies().forEach(newVoie -> {
                                secteurList.getVoies().forEach(voieList -> {
                                    if (newVoie.equals(voieList)) {
                                        voieAdded.set(true);


                                        AtomicBoolean longueurAdded = new AtomicBoolean(false);
                                        newVoie.getLongueurs().forEach(newLongeur -> {
                                            voieList.getLongueurs().forEach( longueurList -> {
                                                if (newLongeur.equals(longueurList)) {
                                                    longueurAdded.set(true);
                                                }
                                            });
                                            if (!longueurAdded.get()) {
                                                voieList.getLongueurs().add(newLongeur);
                                            }

                                        });

                                    }
                                });
                                if (!voieAdded.get()) {
                                    secteurList.getVoies().add(newVoie);
                                }
                            });
                        }
                    });
                    if (!secteurAdded.get()) {
                        s.getSecteurs().add(newSecteur);
                    }
                });

            }
        });
        if (!siteAdded.get()) {
            sites.add(site);
        }
    }

    private Site findSiteForLongueur(Longueur longueur) {
        Voie voie = voieService.findById(longueur.getVoie().getId());
        if (voie != null) {
            Secteur secteur = secteurService.findById(voie.getSecteur().getId());
            if (secteur != null) {
                Site site = siteService.findById(secteur.getSite().getId());
                if (site != null) {
                    site.setSecteurs(Arrays.asList(secteur));
                    secteur.setVoies(Arrays.asList(voie));
                    voie.setLongueurs(Arrays.asList(longueur));
                    return site;
                }
            }
        }
        return null;
    }
}
