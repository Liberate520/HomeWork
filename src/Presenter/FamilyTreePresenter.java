package Presenter;

import Model.FamilyTree;
import Model.Person;
import Util.FileManager;
import View.FamilyTreeView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FileManager fileManager;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Person> familyTree, FileManager fileManager, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.fileManager = fileManager;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getScanner().nextInt();
            view.getScanner().nextLine();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    setParents();
                    break;
                case 3:
                    showAllPeople();
                    break;
                case 4:
                    findByName();
                    break;
                case 5:
                    showChildren();
                    break;
                case 6:
                    showParents();
                    break;
                case 7:
                    saveTree();
                    break;
                case 8:
                    loadTree();
                    break;
                case 0:
                    view.displayMessage("Выход из программы...");
                    return;
                default:
                    view.displayMessage("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addPerson() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите имя: ");
        String firstName = scanner.nextLine();

        view.displayMessage("Введите фамилию: ");
        String lastName = scanner.nextLine();

        LocalDate birthDate = null;
        while (birthDate == null) {
            view.displayMessage("Введите дату рождения (ГГГГ-ММ-ДД): ");
            String birthDateStr = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                view.displayMessage("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
            }
        }

        LocalDate deathDate = null;
        while (deathDate == null) {
            view.displayMessage("Введите дату смерти (ГГГГ-ММ-ДД или оставьте пустым): ");
            String deathDateStr = scanner.nextLine();
            if (deathDateStr.isEmpty()) {
                break;
            }
            try {
                deathDate = LocalDate.parse(deathDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                view.displayMessage("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
            }
        }

        Person.Gender gender = null;
        while (gender == null) {
            view.displayMessage("Введите пол (МУЖЧИНА/ЖЕНЩИНА): ");
            try {
                gender = Person.Gender.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                view.displayMessage("Некорректный ввод пола. Пожалуйста, введите МУЖЧИНА или ЖЕНЩИНА.");
            }
        }

        Person person = new Person(firstName, lastName, birthDate, deathDate, gender);
        familyTree.addPerson(person);
        view.displayMessage("Член семьи успешно добавлен!");
    }

    private void setParents() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID ребенка: ");
        int childId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        view.displayMessage("Введите ID матери: ");
        int motherId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        view.displayMessage("Введите ID отца: ");
        int fatherId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.setParents(childId, motherId, fatherId);
    }

    private void showAllPeople() {
        view.displayMessage("Выберите по какому признаку вы хотите отсортировать:");
        view.displayMessage("1. По имени");
        view.displayMessage("2. По дате рождения");
        int sortChoice = view.getScanner().nextInt();
        view.getScanner().nextLine(); // Consume newline

        switch (sortChoice) {
            case 1:
                familyTree.sort();
                break;
            case 2:
                familyTree.sortByBirthDate();
                break;
            default:
                view.displayMessage("Некорректный выбор. Будет использована сортировка по имени.");
                familyTree.sort();
                break;
        }

        List<Person> people = familyTree.getAllPeople();
        view.displayPeople(people);
    }

    private void findByName() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID, имя или фамилию для поиска: ");
        String searchInput = scanner.nextLine();

        if (searchInput.matches("\\d+")) {
            int searchId = Integer.parseInt(searchInput);
            Person personById = (Person) familyTree.getPerson(searchId);
            if (personById != null) {
                view.displayPerson(personById);
                familyTree.getParents(searchId);
                familyTree.getChildren(searchId);
            } else {
                view.displayMessage("Член семьи с таким ID не найден.");
            }
        } else {
            String[] nameParts = searchInput.split(" ");
            List<Person> matchedPeople;

            if (nameParts.length == 2) {
                matchedPeople = familyTree.findByName(nameParts[0], nameParts[1]);
            } else {
                matchedPeople = familyTree.findByName(searchInput, searchInput);
            }

            if (!matchedPeople.isEmpty()) {
                view.displayPeople(matchedPeople);
            } else {
                view.displayMessage("Член семьи с таким именем или фамилией не найден.");
            }
        }
    }

    private void showChildren() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.getChildren(personId);
    }

    private void showParents() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.getParents(personId);
    }

    private void saveTree() {
        fileManager.saveFamilyTree(familyTree, "family_tree.ser");
        view.displayMessage("Семейное дерево успешно сохранено!");
    }

    private void loadTree() {
        familyTree = (FamilyTree<Person>) fileManager.loadFamilyTree("family_tree.ser");
        if (familyTree != null) {
            view.displayMessage("Семейное дерево успешно загружено!");
        } else {
            view.displayMessage("Ошибка при загрузке семейного дерева.");
        }
    }
}
