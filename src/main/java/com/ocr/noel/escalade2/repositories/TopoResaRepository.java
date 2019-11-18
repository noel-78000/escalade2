package com.ocr.noel.escalade2.repositories;

import com.ocr.noel.escalade2.entities.TopoResa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopoResaRepository extends JpaRepository<TopoResa, Integer> {

    @Query("SELECT t FROM TopoResa t LEFT JOIN FETCH t.user LEFT JOIN FETCH t.topo where t.id = :id")
    Optional<TopoResa> findByIdFetchUserFetchTopo(@Param("id") Integer id);
}
