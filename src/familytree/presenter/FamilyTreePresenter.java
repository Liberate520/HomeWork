package familytree.presenter;

import familytree.commands.Command;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;
import familytree.model.Person;

import java.io.IOException;
import java.time.LocalDate;
//import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FamilyTreePresenter {
    private final FamilyTreeService familyTreeService;
    private final UserInterface view;

    public FamilyTreePresenter(FamilyTreeService familyTreeService, UserInterface view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    public void addMember() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        String genderInput = view.getUserInput("Введите пол (MALE/FEMALE):").toUpperCase();
        Person.Gender gender;
        try {
            gender = Person.Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            view.displayMessage("Некорректный ввод пола. Используется MALE по умолчанию.");
            gender = Person.Gender.MALE;
        }

        LocalDate dateOfBirth = LocalDate.parse(view.getUserInput("Введите дату рождения (YYYY-MM-DD):"));

        LocalDate dateOfDeath = null;
        String deathKnown = view.getUserInput("Известна ли дата смерти? (да/нет):").toLowerCase();
        if (deathKnown.equals("да")) {
            dateOfDeath = LocalDate.parse(view.getUserInput("Введите дату смерти (YYYY-MM-DD):"));
        }

        familyTreeService.addMember(familyName, firstName, fatherName, gender, dateOfBirth, dateOfDeath);
        view.displayMessage("Член семьи добавлен.");
    }

    public void findMember() {
        String familyName = view.getUserInput("Введите фамилию:");
        String firstName = view.getUserInput("Введите имя:");
        String fatherName = view.getUserInput("Введите отчество:");

        var member = familyTreeService.findMember(familyName, firstName, fatherName);
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

        familyTreeService.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
        view.displayMessage("Родительско-детская связь добавлена!");
    }

    public void printSortedByName() {
        var sortedByName = familyTreeService.getSortedByName();
        view.displayPersons(sortedByName);
    }

    public void printSortedByDateOfBirth() {
        var sortedByDateOfBirth = familyTreeService.getSortedByDateOfBirth();
        view.displayPersons(sortedByDateOfBirth);
    }

    public void saveToFile() {
        try {
            familyTreeService.saveToFile("familyTree.dat");
            view.displayMessage("Дерево сохранено успешно!");
        } catch (IOException e) {
            view.displayMessage("Ошибка при сохранении: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try {
            familyTreeService.loadFromFile(filename);
            view.displayMessage("Дерево загружено успешно!");
        } catch (IOException | ClassNotFoundException e) {
            view.displayMessage("Ошибка при загрузке: " + e.getMessage());
        }
    }

    public void handleUserInput() {
        view.showMenu();
        int choice = Integer.parseInt(view.getUserInput("Выберите команду:"));
        switch (choice) {
            case 1 -> addMember();
            case 2 -> findMember();
            case 3 -> addParentChildRelationship();
            case 4 -> printSortedByName();
            case 5 -> printSortedByDateOfBirth();
            case 6 -> saveToFile();
            case 7 -> {
                String filename = view.getUserInput("Введите имя файла для загрузки:");
                loadFromFile(filename);
            }
            case 0 -> System.exit(0);
            default -> view.displayMessage("Некорректный выбор.");
        }
    }
}