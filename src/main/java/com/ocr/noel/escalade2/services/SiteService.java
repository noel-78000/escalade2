package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public Site findByIdFetchSecteurs(Integer id) {
        return siteRepository.findByIdFetchSecteurs(id).orElse(null);
    }

    @Transactional
    public void deleteById(Integer id) {
        siteRepository.deleteById(id);
    }

    @Transactional
    public void delete(Site site) {
        siteRepository.delete(site);
    }
}
