package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.TopoResa;
import com.ocr.noel.escalade2.repositories.TopoResaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopoResaService {

    @Autowired
    TopoResaRepository topoResaRepository;

    public TopoResa findByIdFetchUserFetchTopo(Integer id) {
        return topoResaRepository.findByIdFetchUserFetchTopo(id).orElse(null);
    }
}
