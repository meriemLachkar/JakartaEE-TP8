package com.example.studentapi.repository;

import com.example.studentapi.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface CoursRepository extends JpaRepository<Cours, Long> {
    @Query("""
           SELECT c
           FROM Cours c
           WHERE c.dateDebut <= :fin
           AND c.dateFin >= :debut
           """)
    List<Cours> findByDateBetween(
            @Param("debut") Date debut,
            @Param("fin") Date fin);



}
