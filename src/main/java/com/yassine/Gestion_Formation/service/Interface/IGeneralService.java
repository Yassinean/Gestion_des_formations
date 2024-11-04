package com.yassine.Gestion_Formation.service.Interface;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T,ID> {
    T create(T entity);
    T update(Long id , T entity);
    String delete(Long id);
    Optional<T> findById(ID id);
    List<T> findAll();
    String searchByNom(String nom);
}


