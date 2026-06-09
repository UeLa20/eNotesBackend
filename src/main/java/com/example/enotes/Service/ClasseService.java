package com.example.enotes.Service;
import com.example.enotes.Entity.Classe;
import java.util.List;

public interface ClasseService {
    List<Classe> getAllClasses();
    Classe getClasseById(Integer id);
    Classe saveClasse(Classe classe);
    void deleteClasse(Integer id);
}
