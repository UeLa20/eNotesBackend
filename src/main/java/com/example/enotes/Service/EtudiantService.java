package com.example.enotes.Service;
import com.example.enotes.Entity.Etudiant;
import java.util.List;
public interface EtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Integer id);
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Integer id);
    List<Etudiant> getEtudiantsByClasse(Integer classeId);
}
