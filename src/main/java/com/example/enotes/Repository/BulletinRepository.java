package com.example.enotes.Repository;

import com.example.enotes.Entity.Bulletin;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BulletinRepository extends JpaRepository<Bulletin,Integer> {
    Bulletin findByEtudiantIdUtilisateur(Integer etudiantId);
}
