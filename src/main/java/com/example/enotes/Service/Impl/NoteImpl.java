package com.example.enotes.Service.Impl;

import com.example.enotes.Entity.Note;
import com.example.enotes.Repository.NoteRepository;
import com.example.enotes.Service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Integer id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }
    @Override
    public void deleteNote(Integer id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> getNotesByEtudiant(Integer etudiantId) {
        return noteRepository.findByEtudiantIdUtilisateur(etudiantId);
    }


    @Override
    public List<Note> getNotesByMatiere(Integer matiereId) {
        return noteRepository.findByMatiereIdMatiere(matiereId);
    }

}
