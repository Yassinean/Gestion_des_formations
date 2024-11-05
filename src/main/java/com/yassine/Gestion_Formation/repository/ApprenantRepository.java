package com.yassine.Gestion_Formation.repository;

import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yassine.Gestion_Formation.model.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant,Long> {
    @Query("SELECT a FROM Apprenant a JOIN FETCH a.classe c JOIN FETCH a.formation f")
    Page<Apprenant> findApprenantWithClasseAndFormation(Pageable pageable);
    Optional<Apprenant>findByNom(String nom);
}