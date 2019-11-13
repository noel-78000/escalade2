package com.ocr.noel.escalade2.repositories;

import com.ocr.noel.escalade2.entities.Site;
import com.ocr.noel.escalade2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    @Query("SELECT s FROM Site s LEFT JOIN FETCH s.secteurs WHERE s.id = :id")
    Optional<Site> findByIdFetchSecteurs(@Param("id") Integer id);
}
