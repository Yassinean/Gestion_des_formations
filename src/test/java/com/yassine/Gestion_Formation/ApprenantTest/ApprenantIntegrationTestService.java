package com.yassine.Gestion_Formation.ApprenantTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.yassine.Gestion_Formation.model.Classe;
import com.yassine.Gestion_Formation.repository.ClasseRepository;
import com.yassine.Gestion_Formation.service.Impl.ClasseServiceImpl;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional

public class ApprenantIntegrationTestService {

    @Autowired
    private ClasseServiceImpl classeService;

    @Autowired
    private ClasseRepository classeRepository;

    @Test
    void addClasse_shouldSaveAndReturnClasse() {
        Classe classe = new Classe();
        classe.setNom("Physics");
        classe.setNumSalle("120");
        Classe savedClasse = classeService.create(classe);
        assertNotNull(savedClasse.getId());
        assertEquals("Physics", savedClasse.getNom());
    }

    @Test
    void updateClasse_shouldUpdateAndReturnClasse() {
        Classe classe = new Classe();
        classe.setNom("Chemistry");
        classe.setNumSalle("104");
        classe = classeService.create(classe);

        Classe updatedClasse = new Classe();
        updatedClasse.setNom("Biology");
        updatedClasse.setNumSalle("105");

        Classe result = classeService.update(classe.getId(), updatedClasse);

        assertEquals("Biology", result.getNom());
        assertEquals(105, result.getNumSalle());
    }

    @Test
    void getClasse_shouldReturnClasseById() {
        Classe classe = new Classe();
        classe.setNom("History");
        classe.setNumSalle("106");
        classe = classeService.create(classe);

        Classe result = classeService.findById(classe.getId()).orElse(null);

        assertNotNull(result);
        assertEquals("History", result.getNom());
    }

    @Test
    void deleteClasse_shouldRemoveClasse() {

        Classe classe = new Classe();
        classe.setNom("Geography");
        classe.setNumSalle("107");
        classe = classeService.create(classe);

        classeService.delete(classe.getId());

        assertFalse(classeRepository.existsById(classe.getId()));
    }

    @Test
    void getAllClasses_shouldReturnAllClassesPaginated() {
        // Create and set up the 'Classe' instances using setters
        Classe classe1 = new Classe();
        classe1.setNom("Math");
        classe1.setNumSalle("108");
        classeService.create(classe1);

        Classe classe2 = new Classe();
        classe2.setNom("Science");
        classe2.setNumSalle("109");
        classeService.create(classe2);

        Page<Classe> page = classeService.findAll(PageRequest.of(0, 10));

        assertEquals(2, page.getTotalElements());

    }
}
