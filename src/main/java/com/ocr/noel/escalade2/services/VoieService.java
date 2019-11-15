package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Voie;
import com.ocr.noel.escalade2.repositories.VoieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoieService {

    @Autowired
    VoieRepository voieRepository;

    public Voie findByIdFetchLongueur(Integer id) {
        return voieRepository.findByIdFetchLongueur(id).orElse(null);
    }
}
