package com.yassine.Gestion_Formation.service.Impl;

import java.util.List;
import java.util.Optional;
 
import org.springframework.stereotype.Service;

import com.yassine.Gestion_Formation.exceptions.ApprenantNotFoundException;
import com.yassine.Gestion_Formation.model.Apprenant;
import com.yassine.Gestion_Formation.repository.ApprenantRepository;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApprenantServiceImpl implements IGeneralService<Apprenant, Long> {

    private final ApprenantRepository apprenantRepository;

    @Override
    public Apprenant create(Apprenant entity) {
        return apprenantRepository.save(entity);
    }

    @Override
    public Apprenant update(Long id, Apprenant entity) {
        return apprenantRepository.findById(id)
                .map(existingApprenant -> {
                    existingApprenant.setNom(entity.getNom());
                    existingApprenant.setPrenom(entity.getPrenom());
                    existingApprenant.setEmail(entity.getEmail());
                    existingApprenant.setNiveau(entity.getNiveau());
                    existingApprenant.setClasse(entity.getClasse());
                    existingApprenant.setFormation(entity.getFormation());
                    return apprenantRepository.save(existingApprenant);
                })
                .orElseThrow(() -> new ApprenantNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if(!apprenantRepository.existsById(id)){
            throw new ApprenantNotFoundException(id);
        }
        apprenantRepository.deleteById(id);
        return "apprenant supprimé avec succes !";
    }

    @Override
    public Optional<Apprenant> findById(Long id) {
        if(!apprenantRepository.existsById(id)){
            throw new ApprenantNotFoundException(id);
        }
        return apprenantRepository.findById(id);
    }

    @Override
    public List<Apprenant> findAll() {
        return apprenantRepository.findApprenantWithClasseAndFormation();
    }
}
