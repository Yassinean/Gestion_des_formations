package com.yassine.Gestion_Formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Classe;

public interface ClasseRepository extends JpaRepository<Classe,Long> {

    Optional<Classe> findByNom(String nom);

}
