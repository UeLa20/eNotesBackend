package com.example.enotes.Repository;

import com.example.enotes.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface NoteRepository extends JpaRepository<Note,Integer> {
    List<Note> findByEtudiantIdUtilisateur(Integer idUtilisateur);
    List<Note> findByMatiereIdMatiere(Integer idMatiere);

}
