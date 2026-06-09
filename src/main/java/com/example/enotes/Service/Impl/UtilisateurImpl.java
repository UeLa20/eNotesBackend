package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Utilisateur;
import com.example.enotes.Repository.UtilisateurRepository;
import com.example.enotes.Service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UtilisateurImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

}
