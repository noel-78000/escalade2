package com.ocr.noel.escalade2.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "voie")
public class Voie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "secteur_id")
    private Secteur secteur;

    @OneToMany(
            mappedBy = "voie",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Longueur> longueurs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(List<Longueur> longueurs) {
        this.longueurs = longueurs;
    }
}
