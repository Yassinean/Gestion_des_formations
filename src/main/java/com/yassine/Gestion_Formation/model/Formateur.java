package com.yassine.Gestion_Formation.model;

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
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
}