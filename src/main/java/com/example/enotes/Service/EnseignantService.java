package com.example.enotes.Service;

import com.example.enotes.Entity.Enseignant;
import java.util.List;
public interface EnseignantService {
    List<Enseignant> getAllEnseignants();
    Enseignant getEnseignantById(Integer id);
    Enseignant saveEnseignant(Enseignant enseignant);
    void deleteEnseignant(Integer id);
}
