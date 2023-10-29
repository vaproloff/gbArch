package sem06hw.presentation.queries.views;

import sem06hw.application.interfaces.NotesPresenter;
import sem06hw.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            this.printOne(note);
        }
    }

    @Override
    public void printOne(Note note) {
        System.out.printf("%d: %s%n", note.getId(), note);
    }
}
