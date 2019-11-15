package com.ocr.noel.escalade2.repositories;

import com.ocr.noel.escalade2.entities.Longueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongueurRepository extends JpaRepository<Longueur, Integer> {

    @Query("SELECT l FROM Longueur l WHERE l.cotation like CONCAT(:cot,'%')")
    List<Longueur> findStartWithCotation(@Param("cot") String cotation);
}
