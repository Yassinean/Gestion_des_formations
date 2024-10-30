package com.yassine.Gestion_Formation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom de la classe est obligatoire")
    private String nom;

    @NotBlank(message = "Le numéro de la salle est obligatoire")
    private String numSalle;

    @OneToMany(mappedBy = "classe")
    private List<Apprenant> apprenants;

    @OneToOne(mappedBy = "classe")
    private Formateur formateur;
}
