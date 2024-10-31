package com.yassine.Gestion_Formation.service.Impl;

import com.yassine.Gestion_Formation.model.Apprenant;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApprenantServiceImpl implements IGeneralService<Apprenant,Long> {

    @Override
    public Apprenant create(Apprenant entity) {
        return null;
    }

    @Override
    public Apprenant update(Apprenant entity) {
        return null;
    }

    @Override
    public String delete(Apprenant entity) {
        return "";
    }

    @Override
    public Apprenant findById(Long id) {
        return null;
    }

    @Override
    public List<Apprenant> findAll() {
        return List.of();
    }
}
