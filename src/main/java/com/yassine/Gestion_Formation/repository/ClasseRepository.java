package com.yassine.Gestion_Formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

    String searchByNom(String nom);
    
}
