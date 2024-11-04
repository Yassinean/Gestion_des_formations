package com.yassine.Gestion_Formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur,Long> {
    public String searchByNom(String nom);
}
