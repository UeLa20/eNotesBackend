package com.example.enotes.Controller;

import com.example.enotes.Entity.Classe;
import com.example.enotes.Service.ClasseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {
    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable Integer id) {
        return classeService.getClasseById(id);
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeService.saveClasse(classe);
    }
    @PutMapping("/{id}")
    public Classe updateClasse(@PathVariable Integer id, @RequestBody Classe classeDetails) {
        Classe classe = classeService.getClasseById(id);
        if (classe != null) {
            classe.setNom(classeDetails.getNom());
            classe.setPromotion(classeDetails.getPromotion());
            return classeService.saveClasse(classe);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable Integer id) {
        classeService.deleteClasse(id);
    }
}
