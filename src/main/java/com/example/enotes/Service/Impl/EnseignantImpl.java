package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Enseignant;
import com.example.enotes.Repository.EnseignantRepository;
import com.example.enotes.Service.AdministrateurService;
import com.example.enotes.Service.EnseignantService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantImpl implements EnseignantService {
    private final EnseignantRepository enseignantRepository;

    public EnseignantImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant getEnseignantById(Integer id) {
        return enseignantRepository.findById(id).orElse(null);
    }

    @Override
    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }
    @Override
    public void deleteEnseignant(Integer id) {
        enseignantRepository.deleteById(id);
    }
}
