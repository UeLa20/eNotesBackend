package com.example.enotes.Service;

import com.example.enotes.Entity.Note;
import java.util.List;
public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Integer id);
    Note saveNote(Note note);
    void deleteNote(Integer id);
    List<Note> getNotesByEtudiant(Integer etudiantId);
    List<Note> getNotesByMatiere(Integer matiereId);
}
