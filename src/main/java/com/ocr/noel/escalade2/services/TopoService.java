package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.entities.Topo;
import com.ocr.noel.escalade2.entities.User;
import com.ocr.noel.escalade2.repositories.TopoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopoService {

    @Autowired
    TopoRepository topoRepository;

    @Autowired
    UserService userService;

    public Topo findByIdFetchUser(Integer id) {
        return topoRepository.findByIdFetchUser(id).orElse(null);
    }

    /**
     * Find all topo witch the user is the owner
     *
     * @param userId the user id for whom looking for the topo list
     * @return the topo list of this user
     */
    public List<Topo> findAllByUserId(Integer userId) {
        return topoRepository.findAllByUserId(userId);
    }

    public List<Topo> findAllDispoWithoutUserId(Integer userId) {
        return topoRepository.findAllDispoWithoutUserId(userId);
    }

    public Topo findById(Integer topoId) {
        return topoRepository.findById(topoId).orElse(null);
    }

    @Transactional
    public boolean add(Integer userId, String lieu, String description, String topoPret) {
        if (userId == null || lieu == null || description == null) return false;
        if (lieu.length() == 0 || lieu.length() > 100 || description.length() == 0 || description.length() > 65535)
            return false;
        Topo topo = new Topo();
        topo.setDescription(description);
        User user = userService.findById(userId);
        if (user == null) return false;
        topo.setUser(user);
        topo.setLieu(lieu);
        topo.setDispoResa(false);
        topo.setDtParution(LocalDateTime.now());
        if ("yes".equals(topoPret)) topo.setDispoResa(true);
        else topo.setDispoResa(false);
        topoRepository.save(topo);
        return true;
    }
}
