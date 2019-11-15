package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Longueur;
import com.ocr.noel.escalade2.repositories.LongueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LongueurService {

    @Autowired
    LongueurRepository longueurRepository;


    List<Longueur> findStartWithCotation(String cotation) {
        return longueurRepository.findStartWithCotation(cotation);
    }
}
