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

import com.yassine.Gestion_Formation.model.Formateur;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/formateurs")
public class FomateurController {
    private final IGeneralService<Formateur,Long> formateurService;

    @PostMapping("/add")
    public Formateur createFormateur(@RequestBody Formateur formateur){
        return formateurService.create(formateur);
    }

      
    @GetMapping("/{id}")
    public Optional<Formateur> findById(@PathVariable Long id){
        return formateurService.findById(id);
    }

    @GetMapping("/list")
    public List<Formateur> listFormateur(){
        return formateurService.findAll();
    }

    @PutMapping("/update/{id}")
    public Formateur updateFormateur(@PathVariable Long id,@RequestBody Formateur formateur){
        return formateurService.update(id,formateur);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFormateur(@PathVariable Long id){
        return formateurService.delete(id);
    }

}
