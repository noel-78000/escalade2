package com.ocr.noel.escalade2.repositories;

import com.ocr.noel.escalade2.entities.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Integer> {

    @Query("SELECT t FROM Topo t LEFT JOIN FETCH t.user where t.id = :id")
    Optional<Topo> findByIdFetchUser(@Param("id") Integer id);
}
