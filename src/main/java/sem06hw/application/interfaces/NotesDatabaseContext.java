package sem06hw.application.interfaces;

import sem06hw.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();
    boolean saveChanges();


}
