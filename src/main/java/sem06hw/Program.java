package sem06hw;

import sem06hw.application.ConcreteNoteEditor;
import sem06hw.application.interfaces.NoteEditor;
import sem06hw.application.interfaces.NotesDatabaseContext;
import sem06hw.database.NotesDatabase;
import sem06hw.infrastructure.persistance.Database;
import sem06hw.infrastructure.persistance.DatabaseContext;
import sem06hw.presentation.queries.controllers.NotesController;
import sem06hw.presentation.queries.views.NotesConsolePresenter;

public class Program {
    /**
     * Домашнее задание:
     * Добавить любую новую функцию к нашему приложению, разработанному на семинаре,
     * например, добавление или удаление записи.
     */
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(notesConsolePresenter, context);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();
    }

}
