package com.example.enotes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "classe")
@Data
@NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Integer idClasse;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(length = 50)
    private String promotion;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<Matiere> matieres;
}
