package com.example.enotes.Controller;

import com.example.enotes.Entity.Bulletin;
import com.example.enotes.Entity.Etudiant;
import com.example.enotes.Service.BulletinService;
import com.example.enotes.Service.EtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bulletins")
public class BulletinController {

    private final BulletinService bulletinService;
    private final EtudiantService etudiantService;

    public BulletinController(BulletinService bulletinService, EtudiantService etudiantService) {
        this.bulletinService = bulletinService;
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Bulletin> getAllBulletins() {
        return bulletinService.getAllBulletins();
    }

    @GetMapping("/{id}")
    public Bulletin getBulletinById(@PathVariable Integer id) {
        return bulletinService.getBulletinById(id);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public Bulletin getBulletinByEtudiant(@PathVariable Integer etudiantId) {
        return bulletinService.getBulletinByEtudiantId(etudiantId);
    }

    @PostMapping
    public Bulletin createBulletin(@RequestBody Bulletin bulletin) {
        if (bulletin.getEtudiant() != null && bulletin.getEtudiant().getIdUtilisateur() != null) {
            Etudiant etudiant = etudiantService.getEtudiantById(bulletin.getEtudiant().getIdUtilisateur());
            bulletin.setEtudiant(etudiant);
        }
        return bulletinService.saveBulletin(bulletin);
    }

    @PutMapping("/{id}")
    public Bulletin updateBulletin(@PathVariable Integer id, @RequestBody Bulletin bulletinDetails) {
        Bulletin bulletin = bulletinService.getBulletinById(id);
        if (bulletin != null) {
            bulletin.setMoyenneGenerale(bulletinDetails.getMoyenneGenerale());
            bulletin.setMention(bulletinDetails.getMention());
            if (bulletinDetails.getEtudiant() != null && bulletinDetails.getEtudiant().getIdUtilisateur() != null) {
                Etudiant etudiant = etudiantService.getEtudiantById(bulletinDetails.getEtudiant().getIdUtilisateur());
                bulletin.setEtudiant(etudiant);
            }
            return bulletinService.saveBulletin(bulletin);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBulletin(@PathVariable Integer id) {
        bulletinService.deleteBulletin(id);
    }
}
