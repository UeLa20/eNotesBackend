
package com.example.enotes.Service;

import com.example.enotes.Entity.Matiere;
import java.util.List;
public interface MatiereService {
    List<Matiere> getAllMatieres();
    Matiere getMatiereById(Integer id);
    Matiere saveMatiere(Matiere matiere);
    void deleteMatiere(Integer id);
    List<Matiere> getMatieresByClasse(Integer classeId);
}
