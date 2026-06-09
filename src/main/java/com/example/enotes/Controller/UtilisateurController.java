package com.example.enotes.Controller;


import com.example.enotes.Entity.Administrateur;
import com.example.enotes.Entity.Enseignant;
import com.example.enotes.Entity.Etudiant;
import com.example.enotes.Entity.Utilisateur;
import com.example.enotes.Service.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Integer id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping
    public Utilisateur createUtilisateur(@RequestBody Map<String, Object> payload) {
        String role = (String) payload.get("role");
        Utilisateur utilisateur;

        switch (role) {
            case "ADMIN":
                Administrateur admin = new Administrateur();
                admin.setPrivileges((String) payload.getOrDefault("privileges", "ALL"));
                utilisateur = admin;
                break;
            case "ENSEIGNANT":
                Enseignant enseignant = new Enseignant();
                utilisateur = enseignant;
                break;
            case "ETUDIANT":
                Etudiant etudiant = new Etudiant();
                utilisateur = etudiant;
                break;
            default:
                throw new IllegalArgumentException("Rôle invalide");
        }

        utilisateur.setNom((String) payload.get("nom"));
        utilisateur.setPrenom((String) payload.get("prenom"));
        utilisateur.setEmail((String) payload.get("email"));
        utilisateur.setMotDePasse((String) payload.get("motDePasse"));
        utilisateur.setRole(role);

        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @PutMapping("/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Integer id, @RequestBody Map<String, Object> payload) {
        Optional<Utilisateur> optionalUtilisateur = Optional.ofNullable(utilisateurService.getUtilisateurById(id));
        if (optionalUtilisateur.isEmpty()) {
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }

        Utilisateur utilisateur = optionalUtilisateur.get();
        utilisateur.setNom((String) payload.get("nom"));
        utilisateur.setPrenom((String) payload.get("prenom"));
        utilisateur.setEmail((String) payload.get("email"));
        if (payload.containsKey("motDePasse") && !((String) payload.get("motDePasse")).isEmpty()) {
            utilisateur.setMotDePasse((String) payload.get("motDePasse"));
        }

        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Integer id) {
        utilisateurService.deleteUtilisateur(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Utilisateur> getUtilisateurByEmail(@PathVariable String email) {
        return utilisateurService.getUtilisateurByEmail(email);
    }
}
