package com.yassine.Gestion_Formation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@DiscriminatorValue("FORMATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formateur extends User {

    @NotBlank(message = "La spécialité est obligatoire")
    private String specialite;

    @OneToOne
    @JoinColumn(name = "classe_id")
    @JsonBackReference("classe-formateur")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    @JsonBackReference("formation-formateur")
    private Formation formation;

    public String getClasseNom() {
        return classe != null ? classe.getNom() : null;
    }

    public String getClasseNumSalle() {
        return classe != null ? classe.getNumSalle() : null;
    }

    public Long getFormationId() {
        return formation != null ? formation.getId() : null;
    }

    public String getFormationNom() {
        return formation != null ? formation.getTitre() : null;
    }
}