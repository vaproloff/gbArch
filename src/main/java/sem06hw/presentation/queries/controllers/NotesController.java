package sem06hw.presentation.queries.controllers;

import sem06hw.application.interfaces.NoteEditor;
import sem06hw.domain.Note;

import java.util.Optional;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll() {
        noteEditor.printAll();
    }

    public boolean routeGet(int noteId) {
        Optional<Note> noteOpt = noteEditor.getById(noteId);
        noteOpt.ifPresent(noteEditor::printOne);
        return noteOpt.isPresent();
    }

    public boolean routeAdd(String title, String content) {
        return noteEditor.add(new Note(0, title, content));
    }

    public boolean routeUpdate(int noteId, String title, String content) {
        Optional<Note> noteOpt = noteEditor.getById(noteId);
        noteOpt.ifPresent(note -> {
            note.setTitle(title);
            note.setDetails(content);
            noteEditor.edit(note);
        });
        return noteOpt.isPresent();
    }

    public boolean routeDelete(int noteId) {
        Optional<Note> noteOpt = noteEditor.getById(noteId);
        noteOpt.ifPresent(noteEditor::remove);
        return noteOpt.isPresent();
    }


}
