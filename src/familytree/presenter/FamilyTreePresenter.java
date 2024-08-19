package familytree.presenter;

import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.model.FullName;
import familytree.ui.UserInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private final UserInterface view;
    private final FileDataHandler fileDataHandler = new FileDataHandler();

    public FamilyTreePresenter(FamilyTree<Person> familyTree, UserInterface view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addMember() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        // Запрашиваем пол
        String genderInput = view.getUserInput("Введите пол (MALE/FEMALE):").toUpperCase();
        Person.Gender gender;
        try {
            gender = Person.Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            view.displayMessage("Некорректный ввод пола. Используется MALE по умолчанию.");
            gender = Person.Gender.MALE;
        }

        LocalDate dateOfBirth = LocalDate.parse(view.getUserInput("Введите дату рождения (YYYY-MM-DD):"));

        Person newMember = new Person(new FullName(familyName, firstName, fatherName), gender, dateOfBirth);

        String deathKnown = view.getUserInput("Известна ли дата смерти? (да/нет):").toLowerCase();
        if (deathKnown.equals("да")) {
            LocalDate dateOfDeath = LocalDate.parse(view.getUserInput("Введите дату смерти (YYYY-MM-DD):"));
            newMember.setDateOfDeath(dateOfDeath);
        }

        familyTree.addMember(newMember);
        view.displayMessage("Член семьи добавлен.");
    }


    public void findMember() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        Person member = familyTree.findMemberByFullName(familyName, firstName, fatherName);
        if (member != null) {
            view.displayMessage("Найденный член семьи: " + member);
        } else {
            view.displayMessage("Член семьи не найден.");
        }
    }

    public void addParentChildRelationship() {
        String parentFamilyName = view.getUserInput("Введите фамилию родителя:");
        String parentFirstName = view.getUserInput("Введите имя родителя:");
        String parentFatherName = view.getUserInput("Введите отчество родителя:");

        String childFamilyName = view.getUserInput("Введите фамилию ребенка:");
        String childFirstName = view.getUserInput("Введите имя ребенка:");
        String childFatherName = view.getUserInput("Введите отчество ребенка:");

        familyTree.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
        view.displayMessage("Родительско-детская связь добавлена!");
    }

    public void printSortedByName() {
        List<Person> sortedByName = familyTree.getSortedByName();
        view.displayPersons(sortedByName);
    }

    public void printSortedByDateOfBirth() {
        List<Person> sortedByDateOfBirth = familyTree.getSortedByDateOfBirth();
        view.displayPersons(sortedByDateOfBirth);
    }

    public void saveToFile() {
        try {
            fileDataHandler.saveToFile("familyTree.dat", familyTree);
            view.displayMessage("Дерево сохранено успешно!");
        } catch (IOException e) {
            view.displayMessage("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try {
            FamilyTree<Person> loadedFamilyTree = fileDataHandler.loadFromFile("familyTree.dat");
            // Обновляем ссылку на familyTree
            this.familyTree = loadedFamilyTree;
            view.displayMessage("Дерево загружено успешно!");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Ошибка при загрузке: " + e.getMessage());
        }
    }

    public void handleUserInput() {
        view.showMenu();
        int choice = Integer.parseInt(view.getUserInput("Выберите команду:"));
        switch (choice) {
            case 1:
                addMember();
                break;
            case 2:
                findMember();
                break;
            case 3:
                addParentChildRelationship();
                break;
            case 4:
                printSortedByName();
                break;
            case 5:
                printSortedByDateOfBirth();
                break;
            case 6:
                saveToFile();
                break;
            case 7:
                loadFromFile();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                view.displayMessage("Некорректный выбор.");
                break;
        }
    }
}