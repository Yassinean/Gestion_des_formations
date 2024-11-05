package com.yassine.Gestion_Formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur,Long> {
    Optional<Formateur>findByNom(String nom);
}
