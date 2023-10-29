package sem06hw.application.interfaces;

import sem06hw.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);

    void printOne(Note note);

}
