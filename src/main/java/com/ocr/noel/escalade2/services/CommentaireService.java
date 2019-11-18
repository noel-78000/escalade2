package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Commentaire;
import com.ocr.noel.escalade2.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    public Commentaire findByIdFetchSiteFetchUser(Integer id) {
        return commentaireRepository.findByIdFetchSiteFetchUser(id).orElse(null);
    }
}
