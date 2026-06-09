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

public class Enseignant extends Utilisateur {
    @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<Matiere> matieres;

    @OneToMany(mappedBy = "enseignant")
    @JsonIgnore
    private List<Note> notesSaisies;
}
