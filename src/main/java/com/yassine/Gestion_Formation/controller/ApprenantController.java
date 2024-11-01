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

import com.yassine.Gestion_Formation.model.Apprenant;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/apprenants")
public class ApprenantController {
    private final IGeneralService<Apprenant,Long> formationService;

    @PostMapping("/add")
    public Apprenant createApprenant(@RequestBody Apprenant apprenant){
        return formationService.create(apprenant);
    }

    @GetMapping("/list")
    public List<Apprenant> listApprenant(){
        return formationService.findAll();
    }

    @PutMapping("/update/{id}")
    public Apprenant updateApprenant(@PathVariable Long id,@RequestBody Apprenant apprenant){
        return formationService.update(id,apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApprenant(@PathVariable Long id){
        return formationService.delete(id);
    }

}
