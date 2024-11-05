package com.yassine.Gestion_Formation.service.Interface;

import org.springframework.data.domain.*;
import java.util.Optional;

public interface IGeneralService <T,ID> {
    T create(T entity);
    T update(Long id , T entity);
    String delete(Long id);
    Optional<T> findById(ID id);
    Page<T> findAll(Pageable pageable);
    Optional<T> findByNom(String nom);
}


