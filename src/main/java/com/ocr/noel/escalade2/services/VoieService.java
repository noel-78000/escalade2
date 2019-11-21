package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Secteur;
import com.ocr.noel.escalade2.entities.Voie;
import com.ocr.noel.escalade2.repositories.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoieService {

    @Autowired
    VoieRepository voieRepository;

    @Autowired
    SecteurService secteurService;

    public Voie findByIdFetchLongueur(Integer id) {
        return voieRepository.findByIdFetchLongueur(id).orElse(null);
    }

    public Voie findById(Integer id) {
        return voieRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        voieRepository.deleteById(id);
    }

    public boolean updateVoie(Integer id, String nom) {
        Voie voie = findById(id);
        if (nom != null && nom.length() > 0 && nom.length() <= 100) {
            voie.setNom(nom);
            voieRepository.save(voie);
            return true;
        }
        return false;
    }

    public boolean add(String nom, Integer secteurId) {
        Secteur secteur = secteurService.findById(secteurId);
        if (secteur != null) {
            Voie voie = new Voie();
            voie.setNom(nom);
            voie.setSecteur(secteur);
            voieRepository.save(voie);
            return true;
        }
        return false;
    }
}
