package com.yassine.Gestion_Formation.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yassine.Gestion_Formation.model.Formation;
import com.yassine.Gestion_Formation.repository.FormationRepository;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class FormationServiceImpl implements IGeneralService<Formation, Long> {

private final FormationRepository formationRepository;
    
    @Override
    public Formation create(Formation entity) {
        return formationRepository.save(entity);
    }

    @Override
    public Formation update(Long id, Formation entity) {
        // return formationRepository.findById(id)
        //         .map(existingFormation -> {
        //             existingFormation.setTitre(entity.getTitre());
        //             existingFormation.setNiveau(entity.getNiveau());
        //             existingFormation.setPrerequis(entity.getPrerequis());
        //             existingFormation.setCapaciteMin(entity.getCapaciteMin());
        //             existingFormation.setCapaciteMax(entity.getCapaciteMax());
        //             existingFormation.setDateDebut(entity.getDateDateDebut());
        //             existingFormation.setDateFin(entity.getDateDateFin());
        //             existingFormation.setStatut(entity.getStatut());
        //             existingFormation.setFormateurs(entity.getFormateurs());
        //             existingFormation.setApprenants(entity.getApprenants());
        //             return formationRepository.save(existingFormation);
        //         })
        //         .orElseThrow(() -> new RuntimeException("Formation not found with Id : " + id));
        return null;
    }

    @Override
    public String delete(Long id) {
        formationRepository.deleteById(id);
        return "Formation supprimé avec succes !";
    }

    @Override
    public Optional<Formation> findById(Long id) {
        return formationRepository.findById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }
    
}
