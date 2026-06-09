
package com.example.enotes.Controller;

import com.example.enotes.Entity.Classe;
import com.example.enotes.Entity.Etudiant;
import com.example.enotes.Service.ClasseService;
import com.example.enotes.Service.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;
    private final ClasseService classeService;

    public EtudiantController(EtudiantService etudiantService, ClasseService classeService) {
        this.etudiantService = etudiantService;
        this.classeService = classeService;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/classe/{classeId}")
    public List<Etudiant> getEtudiantsByClasse(@PathVariable Integer classeId) {
        return etudiantService.getEtudiantsByClasse(classeId);
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Integer id) {
        return etudiantService.getEtudiantById(id);
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        etudiant.setRole("ETUDIANT");
        if (etudiant.getClasse() != null && etudiant.getClasse().getIdClasse() != null) {
            Classe classe = classeService.getClasseById(etudiant.getClasse().getIdClasse());
            etudiant.setClasse(classe);
        }
        return etudiantService.saveEtudiant(etudiant);
    }
    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable Integer id, @RequestBody Etudiant etudiantDetails) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        if (etudiant != null) {
            etudiant.setNom(etudiantDetails.getNom());
            etudiant.setPrenom(etudiantDetails.getPrenom());
            etudiant.setEmail(etudiantDetails.getEmail());
            if (etudiantDetails.getMotDePasse() != null && !etudiantDetails.getMotDePasse().isEmpty()) {
                etudiant.setMotDePasse(etudiantDetails.getMotDePasse());
            }
            if (etudiantDetails.getClasse() != null && etudiantDetails.getClasse().getIdClasse() != null) {
                Classe classe = classeService.getClasseById(etudiantDetails.getClasse().getIdClasse());
                etudiant.setClasse(classe);
            }
            return etudiantService.saveEtudiant(etudiant);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
    }
}
