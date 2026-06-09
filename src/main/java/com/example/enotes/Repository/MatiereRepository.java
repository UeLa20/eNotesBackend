
package com.example.enotes.Repository;

import com.example.enotes.Entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MatiereRepository extends JpaRepository<Matiere,Integer> {
    List<Matiere> findByClasseIdClasse(Integer idClasse);
}
