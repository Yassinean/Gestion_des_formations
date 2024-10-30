package com.yassine.Gestion_Formation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@DiscriminatorValue("FORMATEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Formateur extends User {

    @NotBlank(message = "La spécialité est obligatoire")
    private String specialite;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany(mappedBy = "formateur")
    private List<Formation> formations;
}