package com.ocr.noel.escalade2.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topo")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "dispo_resa")
    private Boolean dispoResa;

    @Column(name = "dt_parution")
    private LocalDateTime dtParution;

    @Column(name = "lieu", length = 100)
    private String lieu;

    @Column(name = "description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
