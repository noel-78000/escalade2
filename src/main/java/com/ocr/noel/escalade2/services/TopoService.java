package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Topo;
import com.ocr.noel.escalade2.repositories.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoService {

    @Autowired
    TopoRepository topoRepository;

    public Topo findByIdFetchUser(Integer id) {
        return topoRepository.findByIdFetchUser(id).orElse(null);
    }
}
