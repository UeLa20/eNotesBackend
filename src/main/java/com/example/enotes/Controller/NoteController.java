package com.example.enotes.Controller;

import com.example.enotes.Entity.Enseignant;
import com.example.enotes.Entity.Etudiant;
import com.example.enotes.Entity.Matiere;
import com.example.enotes.Entity.Note;
import com.example.enotes.Service.EnseignantService;
import com.example.enotes.Service.EtudiantService;
import com.example.enotes.Service.MatiereService;
import com.example.enotes.Service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;
    private final EtudiantService etudiantService;
    private final MatiereService matiereService;
    private final EnseignantService enseignantService;

    public NoteController(NoteService noteService, EtudiantService etudiantService, MatiereService matiereService, EnseignantService enseignantService) {
        this.noteService = noteService;
        this.etudiantService = etudiantService;
        this.matiereService = matiereService;
        this.enseignantService = enseignantService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Integer id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        if (note.getEtudiant() != null && note.getEtudiant().getIdUtilisateur() != null) {
            Etudiant etudiant = etudiantService.getEtudiantById(note.getEtudiant().getIdUtilisateur());
            note.setEtudiant(etudiant);
        }
        if (note.getMatiere() != null && note.getMatiere().getIdMatiere() != null) {
            Matiere matiere = matiereService.getMatiereById(note.getMatiere().getIdMatiere());
            note.setMatiere(matiere);
        }
        if (note.getEnseignant() != null && note.getEnseignant().getIdUtilisateur() != null) {
            Enseignant enseignant = enseignantService.getEnseignantById(note.getEnseignant().getIdUtilisateur());
            note.setEnseignant(enseignant);
        }
        return noteService.saveNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Integer id, @RequestBody Note noteDetails) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            note.setValeur(noteDetails.getValeur());
            note.setDateSaisie(noteDetails.getDateSaisie());
            if (noteDetails.getEtudiant() != null && noteDetails.getEtudiant().getIdUtilisateur() != null) {
                Etudiant etudiant = etudiantService.getEtudiantById(noteDetails.getEtudiant().getIdUtilisateur());
                note.setEtudiant(etudiant);
            }
            if (noteDetails.getMatiere() != null && noteDetails.getMatiere().getIdMatiere() != null) {
                Matiere matiere = matiereService.getMatiereById(noteDetails.getMatiere().getIdMatiere());
                note.setMatiere(matiere);
            }
            if (noteDetails.getEnseignant() != null && noteDetails.getEnseignant().getIdUtilisateur() != null) {
                Enseignant enseignant = enseignantService.getEnseignantById(noteDetails.getEnseignant().getIdUtilisateur());
                note.setEnseignant(enseignant);
            }
            return noteService.saveNote(note);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id) {
        noteService.deleteNote(id);
    }

    @GetMapping("/etudiant/{etudiantId}")
    public List<Note> getNotesByEtudiant(@PathVariable Integer etudiantId) {
        return noteService.getNotesByEtudiant(etudiantId);
    }

    @GetMapping("/matiere/{matiereId}")
    public List<Note> getNotesByMatiere(@PathVariable Integer matiereId) {
        return noteService.getNotesByMatiere(matiereId);
    }

    @GetMapping("/etudiant/{etudiantId}/moyenne")
    public Double getMoyenneByEtudiant(@PathVariable Integer etudiantId) {
        List<Note> notes = noteService.getNotesByEtudiant(etudiantId);
        if (notes.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Note note : notes) {
            sum += note.getValeur();
        }
        return sum / notes.size();
    }
}
