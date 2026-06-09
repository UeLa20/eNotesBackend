package com.example.enotes.Entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Administrateur extends Utilisateur {
    private String privileges; // exemple de champ spécifique
}
