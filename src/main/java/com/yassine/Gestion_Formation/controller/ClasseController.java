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

import com.yassine.Gestion_Formation.model.Classe;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/classes")
public class ClasseController {
    private final IGeneralService<Classe,Long> classeService;

    @PostMapping("/add")
    public Classe createClasse(@RequestBody Classe classe){
        return classeService.create(classe);
    }

    @GetMapping("/list")
    public List<Classe> listClasse(){
        return classeService.findAll();
    }

    @PutMapping("/update/{id}")
    public Classe updateClasse(@PathVariable Long id,@RequestBody Classe classe){
        return classeService.update(id,classe);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id){
        return classeService.delete(id);
    }

}
