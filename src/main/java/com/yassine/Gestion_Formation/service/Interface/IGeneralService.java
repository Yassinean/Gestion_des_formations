package com.yassine.Gestion_Formation.service.Interface;

import com.yassine.Gestion_Formation.model.Apprenant;

import java.util.List;

public interface IGeneralService <T,ID> {
    T create(T entity);
    T update(T entity);
    String delete(T entity);
    T findById(ID id);
    List<T> findAll();
}


