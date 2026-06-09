
package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Matiere;
import com.example.enotes.Repository.MatiereRepository;
import com.example.enotes.Service.MatiereService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereImpl implements MatiereService {
    private final MatiereRepository matiereRepository;

    public MatiereImpl(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere getMatiereById(Integer id) {
        return matiereRepository.findById(id).orElse(null);
    }

    @Override
    public Matiere saveMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }
    @Override
    public void deleteMatiere(Integer id) {
        matiereRepository.deleteById(id);
    }

    @Override
    public List<Matiere> getMatieresByClasse(Integer classeId) {
        return matiereRepository.findByClasseIdClasse(classeId);
    }
}
