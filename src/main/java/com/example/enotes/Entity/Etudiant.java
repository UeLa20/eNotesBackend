package com.example.enotes.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Etudiant extends Utilisateur {
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Note> notes;

    @OneToOne(mappedBy = "etudiant")
    @JsonIgnore
    private Bulletin bulletin;
}
