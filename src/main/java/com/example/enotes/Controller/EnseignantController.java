package com.example.enotes.Controller;

import com.example.enotes.Entity.Enseignant;
import com.example.enotes.Service.EnseignantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {
    private final EnseignantService enseignantService;

    public EnseignantController(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public List<Enseignant> getAllEnseignants() {
        return enseignantService.getAllEnseignants();
    }

    @GetMapping("/{id}")
    public Enseignant getEnseignantById(@PathVariable Integer id) {
        return enseignantService.getEnseignantById(id);
    }

    @PostMapping
    public Enseignant createEnseignant(@RequestBody Enseignant enseignant) {
        enseignant.setRole("ENSEIGNANT");
        return enseignantService.saveEnseignant(enseignant);
    }
    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable Integer id, @RequestBody Enseignant enseignantDetails) {
        Enseignant enseignant = enseignantService.getEnseignantById(id);
        if (enseignant != null) {
            enseignant.setNom(enseignantDetails.getNom());
            enseignant.setPrenom(enseignantDetails.getPrenom());
            enseignant.setEmail(enseignantDetails.getEmail());
            if (enseignantDetails.getMotDePasse() != null && !enseignantDetails.getMotDePasse().isEmpty()) {
                enseignant.setMotDePasse(enseignantDetails.getMotDePasse());
            }
            return enseignantService.saveEnseignant(enseignant);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEnseignant(@PathVariable Integer id) {
        enseignantService.deleteEnseignant(id);
    }
}
