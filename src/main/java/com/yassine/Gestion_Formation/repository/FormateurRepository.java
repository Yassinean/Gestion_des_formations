package com.yassine.Gestion_Formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur,Long> {
    List <Formateur>findByNom(String nom);
}
