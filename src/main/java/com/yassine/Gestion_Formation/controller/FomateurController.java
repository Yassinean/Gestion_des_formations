package com.yassine.Gestion_Formation.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.Gestion_Formation.model.Formateur;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/formateurs")
public class FomateurController {
    private final IGeneralService<Formateur,Long> formationService;

    @PostMapping("/add")
    public Formateur createFormateur(@RequestBody Formateur formateur){
        return formationService.create(formateur);
    }

    @GetMapping("/list")
    public List<Formateur> listFormateur(){
        return formationService.findAll();
    }

    @PutMapping("/update/{id}")
    public Formateur updateFormateur(@PathVariable Long id,@RequestBody Formateur formateur){
        return formationService.update(id,formateur);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFormateur(@PathVariable Long id){
        return formationService.delete(id);
    }

}
