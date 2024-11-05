package com.yassine.Gestion_Formation.controller;

import org.springframework.data.domain.*;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.yassine.Gestion_Formation.model.Classe;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/classes")
public class ClasseController {
    private final IGeneralService<Classe, Long> classeService;

    @PostMapping("/add")
    public Classe createClasse(@RequestBody Classe classe) {
        return classeService.create(classe);
    }

    @GetMapping("/{id}")
    public Optional<Classe> findById(@PathVariable Long id) {
        return classeService.findById(id);
    }
    
    @GetMapping("/search")
    public Optional<Classe> findByNom(@RequestParam String nom) {
        return classeService.findByNom(nom);
    }

    @GetMapping("/list")
    public Page<Classe> listClasse(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return classeService.findAll(pageable);
    }

    @PutMapping("/update/{id}")
    public Classe updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        return classeService.update(id, classe);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        return classeService.delete(id);
    }
}
