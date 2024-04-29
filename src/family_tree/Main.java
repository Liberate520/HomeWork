package family_tree;

import family_tree.model.FamilyTreeModel;
import family_tree.model.TextTreeReaderWriter;
import family_tree.view.ConsoleFamilyTreeView;
import family_tree.view.FamilyTreeView;
import family_tree.presenter.FamilyTreePresenter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModel(); // Инициализация модели
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);
        TextTreeReaderWriter readerWriter = new TextTreeReaderWriter(); // Создание объекта для чтения/записи из/в файл

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Меню:");
            System.out.println("1. Показать неотсортированный список членов семьи");
            System.out.println("2. Выполнить сортировку по имени");
            System.out.println("3. Выполнить сортировку по дате рождения");
            System.out.println("4. Найти человека по имени");
            System.out.println("5. Добавить нового человека");
            System.out.println("6. Сохранить дерево в файл");
            System.out.println("7. Загрузить дерево из файла");
            System.out.println("0. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера ввода

            switch (choice) {
                case 1:
                    presenter.onDisplayUnsortedTree();
                    break;
                case 2:
                    presenter.onSortByName();
                    break;
                case 3:
                    presenter.onSortByBirthDate();
                    break;
                case 4:
                    System.out.print("Введите имя для поиска: ");
                    String name = scanner.nextLine(); // Считываем имя ввода
                    presenter.onSearch(name);
                    break;
                case 5:
                    model.addNewPerson(scanner, view);
                    break;
                case 6:
                    System.out.print("Введите имя файла для сохранения: ");
                    String saveFileName = scanner.nextLine();
                    readerWriter.saveTreeToFile(model, saveFileName);
                    break;
                case 7:
                    System.out.print("Введите имя файла для загрузки: ");
                    String loadFileName = scanner.nextLine();
                    model = readerWriter.loadTreeFromFile(loadFileName);
                    presenter = new FamilyTreePresenter(model, view); // Обновляем презентер с новой моделью
                    break;
                case 0:
                    view.displayMessage("Программа завершена.");
                    break;
                default:
                    view.displayErrorMessage("Некорректный выбор.");
                    break;
            }
        } while (choice != 0);
    }
}
