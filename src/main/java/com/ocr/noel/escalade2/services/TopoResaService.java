package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.TopoResa;
import com.ocr.noel.escalade2.repositories.TopoResaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopoResaService {

    @Autowired
    TopoResaRepository topoResaRepository;

    @Autowired
    UserService userService;

    @Autowired
    TopoService topoService;

    public TopoResa findByIdFetchUserFetchTopo(Integer id) {
        return topoResaRepository.findByIdFetchUserFetchTopo(id).orElse(null);
    }

    public List<TopoResa> findAllByTopoIdFetchUser(Integer topoId) {
        return topoResaRepository.findAllByTopoIdFetchUser(topoId);
    }

    @Transactional
    public boolean addResa(Integer topoId, Integer userId) {
        TopoResa topoResa = new TopoResa();
        topoResa.setDtCreation(LocalDateTime.now());
        topoResa.setUser(userService.findById(userId));
        topoResa.setTopo(topoService.findById(topoId));
        topoResa.setAcceptResa(false);
        topoResaRepository.save(topoResa);
        return true;
    }
}
