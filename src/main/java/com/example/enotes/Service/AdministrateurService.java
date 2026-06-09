package com.example.enotes.Service;

import com.example.enotes.Entity.Administrateur;
import java.util.List;
public interface AdministrateurService {
    List<Administrateur> getAllAdministrateurs();
    Administrateur getAdministrateurById(Integer id);
    Administrateur saveAdministrateur(Administrateur admin);
    void deleteAdministrateur(Integer id);
}
