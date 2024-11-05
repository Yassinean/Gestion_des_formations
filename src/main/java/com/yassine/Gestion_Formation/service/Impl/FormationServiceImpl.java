package com.yassine.Gestion_Formation.service.Impl;

import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.yassine.Gestion_Formation.exceptions.FormationNotFoundException;
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
        return formationRepository.findById(id)
                .map(existingFormation -> {
                    existingFormation.setTitre(entity.getTitre());
                    existingFormation.setNiveau(entity.getNiveau());
                    existingFormation.setPrerequis(entity.getPrerequis());
                    existingFormation.setCapaciteMin(entity.getCapaciteMin());
                    existingFormation.setCapaciteMax(entity.getCapaciteMax());
                    existingFormation.setDateDebut(entity.getDateDebut());
                    existingFormation.setDateFin(entity.getDateFin());
                    existingFormation.setStatus(entity.getStatus());
                    existingFormation.setFormateurs(entity.getFormateurs());
                    existingFormation.setApprenants(entity.getApprenants());
                    return formationRepository.save(existingFormation);
                })
                .orElseThrow(() -> new FormationNotFoundException(id));
    }

    @Override
    public String delete(Long id) {
        if (!formationRepository.existsById(id)) {
            throw new FormationNotFoundException(id);
        }
        formationRepository.deleteById(id);
        return "Formation supprimée avec succès !";
    }

    @Override
    public Optional<Formation> findById(Long id) {
        if (!formationRepository.existsById(id)) {
            throw new FormationNotFoundException(id);
        }
        return formationRepository.findById(id);
    }

    @Override
    public Page<Formation> findAll(Pageable pageable) {
        return formationRepository.findAll(pageable);
    }

    @Override
    public Optional<Formation> findByNom(String titre) {
        return formationRepository.findByTitre(titre);
    }
}
