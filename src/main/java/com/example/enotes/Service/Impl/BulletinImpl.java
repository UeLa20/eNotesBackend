package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Bulletin;
import com.example.enotes.Entity.Note;
import com.example.enotes.Repository.BulletinRepository;
import com.example.enotes.Repository.NoteRepository;
import com.example.enotes.Service.BulletinService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulletinImpl implements BulletinService {
    private final BulletinRepository bulletinRepository;
    private final NoteRepository noteRepository;

    public BulletinImpl(BulletinRepository bulletinRepository, NoteRepository noteRepository) {
        this.bulletinRepository = bulletinRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Bulletin> getAllBulletins() {
        List<Bulletin> bulletins = bulletinRepository.findAll();
        for (Bulletin bulletin : bulletins) {
            if (bulletin.getEtudiant() != null) {
                List<Note> notes = noteRepository.findByEtudiantIdUtilisateur(bulletin.getEtudiant().getIdUtilisateur());
                bulletin.setNotes(notes);
            }
        }
        return bulletins;
    }

    @Override
    public Bulletin getBulletinById(Integer id) {
        Bulletin bulletin = bulletinRepository.findById(id).orElse(null);
        if (bulletin != null && bulletin.getEtudiant() != null) {
            List<Note> notes = noteRepository.findByEtudiantIdUtilisateur(bulletin.getEtudiant().getIdUtilisateur());
            bulletin.setNotes(notes);
        }
        return bulletin;
    }

    @Override
    public Bulletin getBulletinByEtudiantId(Integer etudiantId) {
        Bulletin bulletin = bulletinRepository.findByEtudiantIdUtilisateur(etudiantId);
        if (bulletin != null) {
            List<Note> notes = noteRepository.findByEtudiantIdUtilisateur(etudiantId);
            bulletin.setNotes(notes);
        }
        return bulletin;
    }

    @Override
    public Bulletin saveBulletin(Bulletin bulletin) {
        return bulletinRepository.save(bulletin);
    }

    @Override
    public void deleteBulletin(Integer id) {
        bulletinRepository.deleteById(id);
    }
}
