package presenter;

import model.Person;
import model.services.FamilyTreeService;
import view.View;

public class FamilyTreePresenter {
    private FamilyTreeService<Person> service;
    private View view;

    public FamilyTreePresenter(FamilyTreeService<Person> service, View view) {
        this.service = service;
        this.view = view;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            view.showMenu();
            int choice = view.getUserIntInput("");
            switch (choice) {
                case 1 -> addPerson();
                case 2 -> showTree();
                case 3 -> sortByName();
                case 4 -> sortByBirthDate();
                case 5 -> saveTree();
                case 6 -> loadTree();
                case 7 -> exit = true;
                default -> view.displayError("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void addPerson() {
        String name = view.getUserInput("Введите имя: ");
        String birthDate = view.getUserInput("Введите дату рождения (в формате yyyy-mm-dd): ");
        String genderStr = view.getUserInput("Введите пол (MALE или FEMALE): ");
        Integer fatherId = view.getUserIntInput("Введите ID отца (или 0, если нет): ");
        Integer motherId = view.getUserIntInput("Введите ID матери (или 0, если нет): ");
        service.addPerson(name, birthDate, genderStr, fatherId != 0 ? fatherId : null, motherId != 0 ? motherId : null);
    }

    private void showTree() {
        view.display(service.showTree());
    }

    private void sortByName() {
        service.sortByName();
        view.display("Дерево отсортировано по имени.");
    }

    private void sortByBirthDate() {
        service.sortByBirthDate();
        view.display("Дерево отсортировано по дате рождения.");
    }

    private void saveTree() {
        String filename = view.getUserInput("Введите имя файла для сохранения: ");
        service.saveTree(filename);
        view.display("Дерево сохранено в файл " + filename);
    }

    private void loadTree() {
        String filename = view.getUserInput("Введите имя файла для загрузки: ");
        service.loadTree(filename);
        view.display("Дерево загружено из файла " + filename);
    }
}
