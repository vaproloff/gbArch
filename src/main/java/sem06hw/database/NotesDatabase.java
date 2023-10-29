package sem06hw.database;

import sem06hw.infrastructure.persistance.Database;

public class NotesDatabase implements Database {

    private NotesTable notesTable = new NotesTable();


    public NotesTable getNotesTable() {
        return notesTable;
    }
}
