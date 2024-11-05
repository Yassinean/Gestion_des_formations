package com.yassine.Gestion_Formation.controller;


import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.yassine.Gestion_Formation.model.Apprenant;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/apprenants")
public class ApprenantController {
    private final IGeneralService<Apprenant, Long> apprenantService;

    @PostMapping("/add")
    public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.create(apprenant);
    }

    @GetMapping("/{id}")
    public Optional<Apprenant> findById(@PathVariable Long id) {
        return apprenantService.findById(id);
    }

    @GetMapping("/search")
    public Optional<Apprenant> findByNom(@RequestParam String nom) {
        return apprenantService.findByNom(nom);
    }

    @GetMapping("/list")
    public Page<Apprenant> listApprenant(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return apprenantService.findAll(pageable);
    }

    @PutMapping("/update/{id}")
    public Apprenant updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        return apprenantService.update(id, apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApprenant(@PathVariable Long id) {
        return apprenantService.delete(id);
    }
}
