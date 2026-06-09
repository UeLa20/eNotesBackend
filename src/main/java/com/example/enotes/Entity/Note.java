package com.example.enotes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "note")
@Data
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Integer idNote;

    @Column(nullable = false)
    private Double valeur;

    @Column(name = "date_saisie")
    private LocalDate dateSaisie;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_etudiant")
    @JsonIgnoreProperties("notes")
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_matiere")
    @JsonIgnoreProperties("notes")
    private Matiere matiere;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_enseignant")
    @JsonIgnoreProperties("notes")
    private Enseignant enseignant;
}
