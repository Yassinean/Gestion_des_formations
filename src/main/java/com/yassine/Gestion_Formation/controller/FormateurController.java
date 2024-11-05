package com.yassine.Gestion_Formation.controller;


import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.yassine.Gestion_Formation.model.Formateur;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/formateurs")
public class FormateurController {
    private final IGeneralService<Formateur, Long> formateurService;

    @PostMapping("/add")
    public Formateur createFormateur(@RequestBody Formateur formateur) {
        return formateurService.create(formateur);
    }

    @GetMapping("/{id}")
    public Optional<Formateur> findById(@PathVariable Long id) {
        return formateurService.findById(id);
    }

    @GetMapping("/search")
    public Optional<Formateur> findByNom(@RequestParam String nom) {
        return formateurService.findByNom(nom);
    }

    @GetMapping("/list")
    public Page<Formateur> listFormateur(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return formateurService.findAll(pageable);
    }

    @PutMapping("/update/{id}")
    public Formateur updateFormateur(@PathVariable Long id, @RequestBody Formateur formateur) {
        return formateurService.update(id, formateur);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFormateur(@PathVariable Long id) {
        return formateurService.delete(id);
    }
}
