package familytree.presenter;
import familytree.model.FamilyTree;
import familytree.model.Person;


import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.ConsoleUserInterface;

import java.time.LocalDate;
import java.util.List;
import java.io.IOException;



public class FamilyTreePresenter {
    private final FamilyTreeServiceInterface familyTreeService;
    private final ConsoleUserInterface ui;
    private FamilyTree<Person> familyTree;

    public FamilyTreePresenter(FamilyTreeServiceInterface familyTreeService, ConsoleUserInterface ui) {
        this.familyTreeService = familyTreeService;
        this.ui = ui;
    }

    public void handleUserInput() {
        while (true) {
            ui.showMenu();
            String command = ui.getUserInput("Введите команду: ");

            switch (command) {
                case "1":
                    addMember();
                    break;
                case "2":
                    findMember();
                    break;
                case "3":
                    addParentChildRelationship();
                    break;
                case "4":
                    displaySortedByName();
                    break;
                case "5":
                    displaySortedByDateOfBirth();
                    break;
                case "6":
                    saveToFile();
                    break;
                case "7":
                    loadFromFile();
                    break;
                case "0":
                    ui.displayMessage("Выход из программы.");
                    System.exit(0);
                    break;
                default:
                    ui.displayMessage("Неизвестная команда. Попробуйте снова.");
                    break;
            }
        }
    }

    private void addMember() {
        String fullNameInput = ui.getUserInput("Введите ФИО (фамилия имя отчество):");
        String[] nameParts = fullNameInput.split(" ");
        if (nameParts.length < 3) {
            ui.displayMessage("Ошибка: необходимо ввести фамилию, имя и отчество.");
            return;
        }
        String familyName = nameParts[0];
        String firstName = nameParts[1];
        String fatherName = nameParts[2];

        Person.Gender gender = Person.Gender.valueOf(ui.getUserInput("Введите пол (MALE/FEMALE):").toUpperCase());

        LocalDate dateOfBirth = LocalDate.parse(ui.getUserInput("Введите дату рождения (yyyy-mm-dd):"));

        String dateOfDeathInput = ui.getUserInput("Введите дату смерти (yyyy-mm-dd, если нет - оставьте пустым):");
        LocalDate dateOfDeath = dateOfDeathInput.isEmpty() ? null : LocalDate.parse(dateOfDeathInput);

        familyTreeService.addMember(familyName, firstName, fatherName, gender, dateOfBirth, dateOfDeath);
        ui.displayMessage("Член семьи добавлен.");
    }

    private void findMember() {
        String fullNameInput = ui.getUserInput("Введите ФИО для поиска (фамилия имя отчество):");
        String[] nameParts = fullNameInput.split(" ");
        if (nameParts.length < 3) {
            ui.displayMessage("Ошибка: необходимо ввести фамилию, имя и отчество.");
            return;
        }
        Person foundMember = familyTreeService.findMember(nameParts[0], nameParts[1], nameParts[2]);
        if (foundMember != null) {
            ui.displayMessage("Найденный член семьи: " + foundMember);
        } else {
            ui.displayMessage("Член семьи не найден.");
        }
    }

    private void addParentChildRelationship() {
        String parentFullName = ui.getUserInput("Введите ФИО родителя (фамилия имя отчество):");
        String childFullName = ui.getUserInput("Введите ФИО ребенка (фамилия имя отчество):");
        String[] parentParts = parentFullName.split(" ");
        String[] childParts = childFullName.split(" ");

        if (parentParts.length < 3 || childParts.length < 3) {
            ui.displayMessage("Ошибка: необходимо ввести ФИО для родителя и ребенка.");
            return;
        }

        familyTreeService.addParentChildRelationship(
                parentParts[0], parentParts[1], parentParts[2],
                childParts[0], childParts[1], childParts[2]
        );
        ui.displayMessage("Связь родитель-ребенок добавлена.");
    }

    private void displaySortedByName() {
        List<Person> sortedList = familyTreeService.getSortedByName();
        ui.displayMessage("Отсортированные члены семьи:");
        ui.displayPersons(sortedList);
    }

    private void displaySortedByDateOfBirth() {
        List<Person> sortedList = familyTreeService.getSortedByDateOfBirth();
        ui.displayMessage("Отсортированные члены семьи по дате рождения:");
        ui.displayPersons(sortedList);
    }

    private void saveToFile() {
        String filename = ui.getUserInput("Введите имя файла для сохранения:");
        try {
            familyTreeService.saveToFile(filename);
            ui.displayMessage("Дерево семьи успешно сохранено в файл " + filename);
        } catch (IOException e) {
            ui.displayMessage("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        String filename = ui.getUserInput("Введите имя файла для загрузки:");
        try {
            FamilyTree<Person> loadedTree = familyTreeService.loadFromFile(filename);
            ui.displayMessage("Дерево семьи успешно загружено из файла " + filename);
        } catch (IOException | ClassNotFoundException e) {
            ui.displayMessage("Ошибка при загрузке: " + e.getMessage());
        }
    }

}