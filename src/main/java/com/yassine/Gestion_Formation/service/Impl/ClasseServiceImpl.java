package com.yassine.Gestion_Formation.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yassine.Gestion_Formation.model.Classe;
import com.yassine.Gestion_Formation.repository.ClasseRepository;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClasseServiceImpl implements IGeneralService<Classe, Long> {
     
    private final ClasseRepository classeRepository;
    
    @Override
    public Classe create(Classe entity) {
        return classeRepository.save(entity);
    }

    @Override
    public Classe update(Long id, Classe entity) {
        return classeRepository.findById(id)
                .map(existingClasse -> {
                    existingClasse.setNom(entity.getNom());
                    existingClasse.setNumSalle(entity.getNumSalle());
                    existingClasse.setApprenants(entity.getApprenants());
                    existingClasse.setFormateur(entity.getFormateur());
                    return classeRepository.save(existingClasse);
                })
                .orElseThrow(() -> new RuntimeException("Classe not found with Id : " + id));
    }

    @Override
    public String delete(Long id) {
        classeRepository.deleteById(id);
        return "Classe supprimé avec succes !";
    }

    @Override
    public Optional<Classe> findById(Long id) {
        return classeRepository.findById(id);
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }
}
