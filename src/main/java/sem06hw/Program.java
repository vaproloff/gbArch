package sem06hw;

import sem06hw.application.ConcreteNoteEditor;
import sem06hw.application.interfaces.NoteEditor;
import sem06hw.application.interfaces.NotesDatabaseContext;
import sem06hw.database.NotesDatabase;
import sem06hw.infrastructure.persistance.Database;
import sem06hw.infrastructure.persistance.DatabaseContext;
import sem06hw.presentation.queries.controllers.NotesController;
import sem06hw.presentation.queries.views.NotesConsolePresenter;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** МОИ ЗАМЕТКИ ***");
            System.out.println("=======================");
            System.out.println("1. Все заметки");
            System.out.println("2. Добавить заметку");
            System.out.println("3. Редактировать заметку");
            System.out.println("4. Удалить заметку");
            System.out.println("0. ВЫХОД");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            notesController.routeGetAll();
                            break;
                        case 2:
                            System.out.println("Введите заголовок новой заметки: ");
                            String title = scanner.nextLine();
                            System.out.println("Введите текст новой заметки: ");
                            String content = scanner.nextLine();
                            System.out.println(notesController.routeAdd(title, content) ?
                                    "Успешно добавлено!" : "Заметка не была добавлена");
                            break;
                        case 3:
                            System.out.println("Введите ID заметки: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                scanner.nextLine();
                                if (notesController.routeGet(noteId)) {
                                    System.out.println("Введите новый заголовок: ");
                                    String newTitle = scanner.nextLine();
                                    System.out.println("Введите новый текст: ");
                                    String newContent = scanner.nextLine();
                                    System.out.println(notesController.routeUpdate(noteId, newTitle, newContent) ?
                                            "Успешно!" : "ID заметки указан некорректно.");
                                } else {
                                    System.out.println("ID заметки указан некорректно.");
                                }
                            } else {
                                System.out.println("ID заметки указан некорректно.");
                            }
                            break;
                        case 4:
                            System.out.println("Введите ID заметки: ");
                            if (scanner.hasNextInt()) {
                                int noteId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(notesController.routeDelete(noteId) ?
                                        "Успешно!" : "ID заметки указан некорректно.");
                            } else {
                                System.out.println("ID заметки указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }

}
