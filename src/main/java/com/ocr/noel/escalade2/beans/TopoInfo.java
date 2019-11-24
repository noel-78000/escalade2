package com.ocr.noel.escalade2.beans;

import com.ocr.noel.escalade2.entities.TopoResa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TopoInfo {

    private String lieu;
    private String description;
    private Boolean dispoResa;
    private LocalDateTime dtParution;
    private List<TopoResa> topoResas;

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDispoResa() {
        return dispoResa;
    }

    public void setDispoResa(Boolean dispoResa) {
        this.dispoResa = dispoResa;
    }

    public LocalDateTime getDtParution() {
        return dtParution;
    }

    public void setDtParution(LocalDateTime dtParution) {
        this.dtParution = dtParution;
    }

    public String getDtParutionFormated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtParution.format(formatter);
    }

    public List<TopoResa> getTopoResas() {
        return topoResas;
    }

    public void setTopoResas(List<TopoResa> topoResas) {
        this.topoResas = topoResas;
    }
}
