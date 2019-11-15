package com.ocr.noel.escalade2.repositories;

import com.ocr.noel.escalade2.entities.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

    @Query("SELECT s FROM Secteur s LEFT JOIN FETCH s.voies WHERE s.id = :id")
    Optional<Secteur> findByIdFetchVoies(@Param("id") Integer id);
}
