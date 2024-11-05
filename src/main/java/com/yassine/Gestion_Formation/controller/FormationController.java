package com.yassine.Gestion_Formation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.yassine.Gestion_Formation.model.Formation;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/formations")
public class FormationController {
    private final IGeneralService<Formation, Long> formationService;

    @PostMapping("/add")
    public Formation createFormation(@RequestBody Formation formation) {
        return formationService.create(formation);
    }

    @GetMapping("/{id}")
    public Optional<Formation> findById(@PathVariable Long id) {
        return formationService.findById(id);
    }

    @GetMapping("/list")
    public List<Formation> listFormation() {
        return formationService.findAll();
    }

    @PutMapping("/update/{id}")
    public Formation updateFormation(@PathVariable Long id, @RequestBody Formation formation) {
        return formationService.update(id, formation);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFormation(@PathVariable Long id) {
        return formationService.delete(id);
    }
}
