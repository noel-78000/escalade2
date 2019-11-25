package com.ocr.noel.escalade2.services;

import com.ocr.noel.escalade2.beans.TopoInfo;
import com.ocr.noel.escalade2.entities.Topo;
import com.ocr.noel.escalade2.entities.TopoResa;
import com.ocr.noel.escalade2.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopoInfoService {

    @Autowired
    TopoService topoService;

    @Autowired
    TopoResaService topoResaService;

    public List<TopoInfo> findAllByUserId(User user) {
        List<Topo> topos = topoService.findAllByUserId(user.getId());
        List<TopoInfo> topoInfos = new ArrayList<>();
        topos.forEach(topo -> {
            List<TopoResa> topoResas = topoResaService.findAllByTopoIdFetchUser(topo.getId());
            topoInfos.add(getTopoInfo(topo, topoResas));
        });
        return topoInfos;
    }

    private TopoInfo getTopoInfo(Topo topo, List<TopoResa> topoResas) {
        TopoInfo topoInfo = new TopoInfo();
        topoInfo.setId(topo.getId());
        topoInfo.setLieu(topo.getLieu());
        topoInfo.setDescription(topo.getDescription());
        topoInfo.setDispoResa(topo.getDispoResa());
        topoInfo.setDtParution(topo.getDtParution());
        topoInfo.setTopoResas(topoResas);
        return topoInfo;
    }
}
