package com.yassine.Gestion_Formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yassine.Gestion_Formation.model.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant,Long> {
}