package com.yassine.Gestion_Formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Formation;

public interface FormationRepository extends JpaRepository<Formation,Long> {
    Optional<Formation> findByTitre(String titre);
}