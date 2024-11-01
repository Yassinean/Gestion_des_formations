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

import com.yassine.Gestion_Formation.model.Formation;
import com.yassine.Gestion_Formation.service.Interface.IGeneralService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/formations")
public class FomationController {
    private final IGeneralService<Formation,Long> formationService;

    @PostMapping("/add")
    public Formation createFormation(@RequestBody Formation fomation){
        return formationService.create(fomation);
    }

    @GetMapping("/{id}")
    public Optional<Formation> findById(@PathVariable Long id){
        return formationService.findById(id);
    }

    @GetMapping("/list")
    public List<Formation> listFormation(){
        return formationService.findAll();
    }

    @PutMapping("/update/{id}")
    public Formation updateFormation(@PathVariable Long id,@RequestBody Formation fomation){
        return formationService.update(id,fomation);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFormation(@PathVariable Long id){
        return formationService.delete(id);
    }

}
