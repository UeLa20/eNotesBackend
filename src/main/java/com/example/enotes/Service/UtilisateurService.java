package com.example.enotes.Service;

import com.example.enotes.Entity.Utilisateur;
import java.util.List;
import java.util.Optional;
public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurById(Integer id);
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Integer id);
    Optional<Utilisateur> getUtilisateurByEmail(String email);
}
