package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Commentaire;
import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SiteService siteService;


    public Commentaire findByIdFetchSiteFetchUser(Integer id) {
        return commentaireRepository.findByIdFetchSiteFetchUser(id).orElse(null);
    }

    public List<Commentaire> findAllBySiteIdFetchUser(Integer siteId) {
        return commentaireRepository.findAllBySiteIdFetchUser(siteId);
    }

    @Transactional
    public boolean addNew(String comment, Integer siteId, Principal principal) {
        if (comment == null || comment.length() == 0 || comment.length() > 65535 || siteId == null || principal == null)
            return false;
        Site site = siteService.findById(siteId);
        User user = userService.getUserFromPrincipalAndDB(principal);
        if (user == null || site == null) return false;
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaire(comment);
        commentaire.setSite(site);
        commentaire.setUser(user);
        commentaire.setDtCreation(LocalDateTime.now());
        commentaireRepository.save(commentaire);
        return true;
    }

    @Transactional
    public void delete(Integer commentId, Principal principal) {
        boolean isAtLestAssoLevel = userService.isAtLeastAssociationLevel(principal);
        if (isAtLestAssoLevel) commentaireRepository.deleteById(commentId);
    }

    @Transactional
    public boolean change(String comment, Integer commentId, Principal principal) {
        if (comment == null || commentId == null || principal == null) return false;
        if (!userService.isAtLeastAssociationLevel(principal)) return false;
        Commentaire commentaire = commentaireRepository.findById(commentId).orElse(null);
        if (commentaire == null) return false;
        User user = userService.getUserFromPrincipalAndDB(principal);
        commentaire.setUser(user);
        commentaire.setCommentaire(comment);
        commentaireRepository.save(commentaire);
        return true;
    }
}
