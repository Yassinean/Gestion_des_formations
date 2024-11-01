package com.yassine.Gestion_Formation.controller;


import java.util.List;
import java.util.Optional;

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
    private final IGeneralService<Apprenant,Long> apprenantService;

    @PostMapping("/add")
    public Apprenant createApprenant(@RequestBody Apprenant apprenant){
        return apprenantService.create(apprenant);
    }

    @GetMapping("/{id}")
    public Optional<Apprenant> findById(@PathVariable Long id){
        return apprenantService.findById(id);
    }

    @GetMapping("/list")
    public List<Apprenant> listApprenant(){
        return apprenantService.findAll();
    }

    @PutMapping("/update/{id}")
    public Apprenant updateApprenant(@PathVariable Long id,@RequestBody Apprenant apprenant){
        return apprenantService.update(id,apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteApprenant(@PathVariable Long id){
        return apprenantService.delete(id);
    }

}
