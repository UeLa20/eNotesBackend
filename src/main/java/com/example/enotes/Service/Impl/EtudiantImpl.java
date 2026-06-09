package com.example.enotes.Service.Impl;
import com.example.enotes.Entity.Etudiant;
import com.example.enotes.Repository.EtudiantRepository;
import com.example.enotes.Service.EtudiantService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantImpl implements EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }
    @Override
    public List<Etudiant> getEtudiantsByClasse(Integer classeId) {
        return etudiantRepository.findByClasseIdClasse(classeId);
    }

}
