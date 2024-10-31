package com.yassine.Gestion_Formation.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yassine.Gestion_Formation.model.Formateur;
import com.yassine.Gestion_Formation.repository.FormateurRepository;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class FormateurServiceImpl implements IGeneralService<Formateur, Long> {
    private final FormateurRepository formateurRepository;
    
    @Override
    public Formateur create(Formateur entity) {
        return formateurRepository.save(entity);
    }

    @Override
    public Formateur update(Long id, Formateur entity) {
        return formateurRepository.findById(id)
                .map(existingFormateur -> {
                    existingFormateur.setNom(entity.getNom());
                    existingFormateur.setPrenom(entity.getPrenom());
                    existingFormateur.setEmail(entity.getEmail());
                    existingFormateur.setSpecialite(entity.getSpecialite());
                    existingFormateur.setClasse(entity.getClasse());
                    existingFormateur.setFormation(entity.getFormation());
                    return formateurRepository.save(existingFormateur);
                })
                .orElseThrow(() -> new RuntimeException("Formateur not found with Id : " + id));
    }

    @Override
    public String delete(Long id) {
        formateurRepository.deleteById(id);
        return "Formateur supprimé avec succes !";
    }

    @Override
    public Optional<Formateur> findById(Long id) {
        return formateurRepository.findById(id);
    }

    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }
}
