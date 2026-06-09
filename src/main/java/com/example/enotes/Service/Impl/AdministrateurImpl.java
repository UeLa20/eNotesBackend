package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Administrateur;
import com.example.enotes.Repository.AdministrateurRepository;
import com.example.enotes.Service.AdministrateurService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministrateurImpl implements AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurImpl(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    @Override
    public Administrateur getAdministrateurById(Integer id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    @Override
    public Administrateur saveAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @Override
    public void deleteAdministrateur(Integer id) {
        administrateurRepository.deleteById(id);
    }
}
