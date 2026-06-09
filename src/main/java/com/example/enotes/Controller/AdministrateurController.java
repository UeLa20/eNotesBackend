package com.example.enotes.Controller;

import com.example.enotes.Entity.Administrateur;
import com.example.enotes.Service.AdministrateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrateurs")
public class AdministrateurController {
    private final AdministrateurService administrateurService;

    public AdministrateurController(AdministrateurService administrateurService) {
        this.administrateurService = administrateurService;
    }

    @GetMapping
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAllAdministrateurs();
    }

    @GetMapping("/{id}")
    public Administrateur getAdministrateurById(@PathVariable Integer id) {
        return administrateurService.getAdministrateurById(id);
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurService.saveAdministrateur(administrateur);
    }
    @PutMapping("/{id}")
    public Administrateur updateAdministrateur(@PathVariable Integer id, @RequestBody Administrateur administrateur) {
        administrateur.setIdUtilisateur(id);
        return administrateurService.saveAdministrateur(administrateur);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrateur(@PathVariable Integer id) {
        administrateurService.deleteAdministrateur(id);
    }
}
