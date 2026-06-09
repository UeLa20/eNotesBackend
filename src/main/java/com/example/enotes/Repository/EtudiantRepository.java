package com.example.enotes.Repository;

import com.example.enotes.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    List<Etudiant> findByClasseIdClasse(Integer idClasse);

}
