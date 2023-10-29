package sem06hw.application;

import sem06hw.application.interfaces.NoteEditor;
import sem06hw.application.interfaces.NotesDatabaseContext;
import sem06hw.application.interfaces.NotesPresenter;
import sem06hw.domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(
            NotesPresenter presenter,
            NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    @Override
    public boolean add(Note item) {
        return dbContext.addNote(item);
    }

    @Override
    public boolean edit(Note item) {
        return dbContext.updateNote(item);
    }

    @Override
    public boolean remove(Note item) {
        return dbContext.deleteNote(item);
    }

    @Override
    public Optional<Note> getById(Integer noteId) {
        for (Note note : dbContext.getAll()) {
            if (noteId == note.getId()) {
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        presenter.printAll(getAll());
    }

    @Override
    public void printOne(Note item) {
        presenter.printOne(item);
    }
}
