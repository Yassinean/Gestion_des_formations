package com.yassine.Gestion_Formation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@DiscriminatorValue("APPRENANT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apprenant extends User {

    @NotBlank(message = "Le niveau est obligatoire")
    private String niveau;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;
}

