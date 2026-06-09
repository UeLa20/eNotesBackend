
package com.example.enotes.Controller;

import com.example.enotes.Entity.Utilisateur;
import com.example.enotes.Service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UtilisateurService utilisateurService;

    public AuthController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String motDePasse = loginRequest.get("motDePasse");

        Optional<Utilisateur> utilisateurOpt = utilisateurService.getUtilisateurByEmail(email);

        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            if (utilisateur.getMotDePasse().equals(motDePasse)) {
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Connexion réussie");
                response.put("utilisateur", utilisateur);
                return ResponseEntity.ok(response);
            } else {
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Mot de passe incorrect");
                return ResponseEntity.status(401).body(response);
            }
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Utilisateur non trouvé");
            return ResponseEntity.status(404).body(response);
        }
    }
}
