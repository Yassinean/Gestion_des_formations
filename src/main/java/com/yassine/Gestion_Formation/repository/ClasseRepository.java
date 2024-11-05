package com.yassine.Gestion_Formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

    List<Classe> findByNom(String nom);

}
