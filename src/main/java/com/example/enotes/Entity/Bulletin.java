package com.example.enotes.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bulletin")
@Data
@NoArgsConstructor
public class Bulletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bulletin")
    private Integer idBulletin;

    private Double moyenneGenerale;
    private String mention;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_etudiant")
    @JsonIgnoreProperties("bulletin")
    private Etudiant etudiant;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("bulletin")
    private List<Note> notes;
}
