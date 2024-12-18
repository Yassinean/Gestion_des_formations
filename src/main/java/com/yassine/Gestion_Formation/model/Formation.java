package com.yassine.Gestion_Formation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.yassine.Gestion_Formation.model.Enum.StatutFormation;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le titre de la formation est obligatoire")
    private String titre;

    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    @NotBlank(message = "Les prérequis sont obligatoires")
    private String prerequis;

    @Min(value = 1, message = "La capacité minimale doit être au moins de 1")
    private int capaciteMin;

    @Max(value = 100, message = "La capacité maximale ne doit pas dépasser 100")
    private int capaciteMax;

    @NotNull(message = "La date de début est obligatoire")
    private LocalDate dateDebut;

    @NotNull(message = "La date de fin est obligatoire")
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le statut de la formation est obligatoire")
    private StatutFormation status;

  @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Apprenant> apprenants = new ArrayList<>();

    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL)
    private List<Formateur> formateurs = new ArrayList<>();

}
