
package com.example.enotes.Controller;

import com.example.enotes.Entity.Classe;
import com.example.enotes.Entity.Enseignant;
import com.example.enotes.Entity.Matiere;
import com.example.enotes.Service.ClasseService;
import com.example.enotes.Service.EnseignantService;
import com.example.enotes.Service.MatiereService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/matieres")
public class MatiereController {

    private final MatiereService matiereService;
    private final EnseignantService enseignantService;
    private final ClasseService classeService;

    public MatiereController(MatiereService matiereService, EnseignantService enseignantService, ClasseService classeService) {
        this.matiereService = matiereService;
        this.enseignantService = enseignantService;
        this.classeService = classeService;
    }

    @GetMapping
    public List<Matiere> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @GetMapping("/classe/{classeId}")
    public List<Matiere> getMatieresByClasse(@PathVariable Integer classeId) {
        return matiereService.getMatieresByClasse(classeId);
    }

    @GetMapping("/{id}")
    public Matiere getMatiereById(@PathVariable Integer id) {
        return matiereService.getMatiereById(id);
    }

    @PostMapping
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        if (matiere.getEnseignant() != null && matiere.getEnseignant().getIdUtilisateur() != null) {
            Enseignant enseignant = enseignantService.getEnseignantById(matiere.getEnseignant().getIdUtilisateur());
            matiere.setEnseignant(enseignant);
        }
        if (matiere.getClasse() != null && matiere.getClasse().getIdClasse() != null) {
            Classe classe = classeService.getClasseById(matiere.getClasse().getIdClasse());
            matiere.setClasse(classe);
        }
        return matiereService.saveMatiere(matiere);
    }

    @PutMapping("/{id}")
    public Matiere updateMatiere(@PathVariable Integer id, @RequestBody Matiere matiereDetails) {
        Matiere matiere = matiereService.getMatiereById(id);
        if (matiere != null) {
            matiere.setNom(matiereDetails.getNom());
            matiere.setDescription(matiereDetails.getDescription());
            if (matiereDetails.getEnseignant() != null && matiereDetails.getEnseignant().getIdUtilisateur() != null) {
                Enseignant enseignant = enseignantService.getEnseignantById(matiereDetails.getEnseignant().getIdUtilisateur());
                matiere.setEnseignant(enseignant);
            }
            if (matiereDetails.getClasse() != null && matiereDetails.getClasse().getIdClasse() != null) {
                Classe classe = classeService.getClasseById(matiereDetails.getClasse().getIdClasse());
                matiere.setClasse(classe);
            }
            return matiereService.saveMatiere(matiere);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMatiere(@PathVariable Integer id) {
        matiereService.deleteMatiere(id);
    }
}
