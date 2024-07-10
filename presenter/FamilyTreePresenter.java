package presenter;

import model.Gender;
import model.Person;
import model.services.FamilyTreeService;
import view.ConsoleView;
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
            int choice = ((ConsoleView) view).getUserChoice();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    showTree();
                    break;
                case 3:
                    sortByName();
                    showTree();
                    break;
                case 4:
                    sortByBirthDate();
                    showTree();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    view.displayError("Неверная опция, попробуйте снова.");
            }
        }
    }

    private void addPerson() {
        ConsoleView consoleView = (ConsoleView) view;
        consoleView.display("Введите имя:");
        String name = consoleView.getUserInput();
        consoleView.display("Введите дату рождения (в формате yyyy-mm-dd):");
        String birthDate = consoleView.getUserInput();
        consoleView.display("Введите пол (MALE или FEMALE):");
        String genderStr = consoleView.getUserInput();
        consoleView.display("Введите ID отца (или -1, если неизвестно):");
        int fatherId = consoleView.getUserIntInput();
        consoleView.display("Введите ID матери (или -1, если неизвестно):");
        int motherId = consoleView.getUserIntInput();

        try {
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            Integer fatherIdObj = fatherId != -1 ? fatherId : null;
            Integer motherIdObj = motherId != -1 ? motherId : null;
            Person person = new Person(name, birthDate, gender);
            service.addPerson(person, fatherIdObj, motherIdObj);
            view.display("Человек добавлен с ID: " + person.getId());
        } catch (IllegalArgumentException e) {
            view.displayError("Неверный ввод пола. Пожалуйста, используйте MALE или FEMALE.");
        }
    }

    private void showTree() {
        view.display(service.showTree());
    }

    private void sortByName() {
        service.sortByName();
    }

    private void sortByBirthDate() {
        service.sortByBirthDate();
    }
}
