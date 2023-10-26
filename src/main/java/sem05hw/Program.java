package sem05hw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Program {
    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация .., в файловой системе компьютера).
     * <p>
     * Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере…
     * <p>
     * Домашнее задание:
     * 1. Добавить одну или несколько функций (features) в рамках разработанного программного комплекса на семинаре,
     * например, функцию добавления/удаления 3D модели/текстуры.
     * 2. Если доработка приложения будет вызывать затруднение, постараетесь сформировать формальную UML-диаграмму
     * по текущему комплексу.
     * Для выполнения домашней работы, достаточно выполнить одну подзадачу.
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Выполнить рендер всех моделей");
            System.out.println("6. Выполнить рендер модели");
            System.out.println("7. Добавить модель в проект");
            System.out.println("8. Удалить модель из проекта");
            System.out.println("9. Отобразить все текстуры проекта");
            System.out.println("10. Добавить текстуру в проект");
            System.out.println("11. Удалить текстуру из проекта");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
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
                            System.out.print("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.renderAll();
                            break;
                        case 6:
                            System.out.print("Укажите ID модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("ID модели указан некорректно.");
                            }
                            break;
                        case 7:
                            System.out.print("Укажите имя модели или оставьте пустым: ");
                            String modelName = scanner.nextLine();
                            Collection<Texture> textures = new ArrayList<>();
                            System.out.print("Укажите номер текстуры для добавления в модель или оставьте пустым: ");
                            String input = scanner.nextLine();
                            while (!input.isBlank()) {
                                int textureNo = -1;
                                try {
                                    textureNo = Integer.parseInt(input);
                                } catch (NumberFormatException e) {
                                    System.out.println("ID текстуры указан некорректно.");
                                }
                                Texture texture = editor3D.getTexture(textureNo);
                                if (texture != null) {
                                    textures.add(texture);
                                } else {
                                    System.out.println("ID текстуры указан некорректно.");
                                }
                                System.out.print("Укажите номер текстуры для добавления в модель или оставьте пустым: ");
                                input = scanner.nextLine();
                            }
                            editor3D.addModel(modelName, textures);
                            break;
                        case 8:
                            System.out.print("Укажите ID модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                editor3D.deleteModel(modelNo);
                            } else {
                                System.out.println("ID модели указан некорректно.");
                            }
                            break;
                        case 9:
                            editor3D.printAllTextures();
                            break;
                        case 10:
                            System.out.print("Укажите имя текстуры или оставьте пустым: ");
                            String textureName = scanner.nextLine();
                            editor3D.addTexture(textureName);
                            break;
                        case 11:
                            System.out.print("Укажите ID текстуры: ");
                            if (scanner.hasNextInt()) {
                                int textureNo = scanner.nextInt();
                                editor3D.deleteTexture(textureNo);
                            } else {
                                System.out.println("ID текстуры указан некорректно.");
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
