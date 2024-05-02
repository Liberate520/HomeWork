package family_tree;

import family_tree.model.FamilyTreeModel;
import family_tree.model.TextTreeReaderWriter;
import family_tree.presenter.FamilyTreePresenter;
import family_tree.view.ConsoleFamilyTreeView;
import family_tree.view.UserInterface;
import java.util.Scanner;
import family_tree.model.TreePersistenceService;

public class Main implements UserInterface {
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMenu() {
        // Вывод меню
        System.out.println("Меню:");
        System.out.println("1. Показать неотсортированный список членов семьи");
        System.out.println("2. Выполнить сортировку по имени");
        System.out.println("3. Выполнить сортировку по дате рождения");
        System.out.println("4. Найти человека по имени");
        System.out.println("5. Добавить нового человека");
        System.out.println("6. Сохранить дерево в файл");
        System.out.println("7. Загрузить дерево из файла");
        System.out.println("0. Выйти из программы");
    }

    @Override
    public int getUserChoice() {
        System.out.print("Выберите действие: ");
        return scanner.nextInt();
    }

    @Override
    public String getInput() {
        scanner.nextLine(); // Очистка буфера ввода
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModel();
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        TreePersistenceService persistenceService = new TextTreeReaderWriter();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view, persistenceService);
        Main ui = new Main();

        int choice;
        do {
            ui.displayMenu();
            choice = ui.getUserChoice();

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
                    ui.showMessage("Введите имя для поиска: ");
                    String name = ui.getInput();
                    presenter.onSearch(name);
                    break;
                case 5:
                    presenter.addNewPerson();
                    break;
                case 6:
                    ui.showMessage("Введите имя файла для сохранения: ");
                    String saveFileName = ui.getInput();
                    persistenceService.saveTreeToFile(model, saveFileName);
                    break;
                case 7:
                    ui.showMessage("Введите имя файла для загрузки: ");
                    String loadFileName = ui.getInput();
                    model = persistenceService.loadTreeFromFile(loadFileName);
                    presenter = new FamilyTreePresenter(model, view, persistenceService);
                    break;
                case 0:
                    ui.showMessage("Программа завершена.");
                    break;
                default:
                    ui.showErrorMessage("Некорректный выбор.");
                    break;
            }
        } while (choice != 0);
    }
}
