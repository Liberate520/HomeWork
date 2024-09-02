package Presenter;

import Model.Person;
import Service.FamilyTreeService;
import View.ConsoleView;
import View.FamilyTreeView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FamilyTreePresenter {
    private final FamilyTreeService service;
    private final FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
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
                    findByNameOrId();
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
                case 9:
                    editPerson();
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

        LocalDate birthDate = ((ConsoleView) view).getDateInput("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate deathDate = ((ConsoleView) view).getDateInput("Введите дату смерти (ГГГГ-ММ-ДД), если известно, или оставьте поле пустым: ");
        Person.Gender gender = ((ConsoleView) view).getGenderInput("Введите гендер (МУЖЧИНА/ЖЕНЩИНА): ");

        service.addPerson(firstName, lastName, birthDate, deathDate, gender);
        view.displayMessage("Человек успешно добавлен в семейное древо.");
    }

    private void setParents() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID ребенка: ");
        int childId = scanner.nextInt();
        scanner.nextLine(); // Поглощение новой строки

        view.displayMessage("Введите ID матери: ");
        int motherId = scanner.nextInt();
        scanner.nextLine(); // Поглощение новой строки

        view.displayMessage("Введите ID отца: ");
        int fatherId = scanner.nextInt();
        scanner.nextLine(); // Поглощение новой строки

        service.setParents(childId, motherId, fatherId);
    }

    private void showAllPeople() {
        view.displayMessage("Выберите по какому признаку вы хотите отсортировать:");
        view.displayMessage("1. По имени");
        view.displayMessage("2. По дате рождения");
        int sortChoice = view.getScanner().nextInt();
        view.getScanner().nextLine(); // Поглощение новой строки

        switch (sortChoice) {
            case 1:
                service.getFamilyTree().sort();
                break;
            case 2:
                service.getFamilyTree().sortByBirthDate();
                break;
            default:
                view.displayMessage("Некорректный выбор. Будет использована сортировка по имени.");
                service.getFamilyTree().sort();
                break;
        }

        List<Person> people = (List<Person>) service.getFamilyTree().getAllPeople();
        view.displayPeople(people);
    }

    private void findByNameOrId() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID, имя или фамилию для поиска: ");
        String searchInput = scanner.nextLine();
        Person person = service.findByNameOrId(searchInput);

        if (person != null) {
            view.displayPerson(person);
        } else {
            view.displayMessage("Член семьи не найден.");
        }
    }

    private void showChildren() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Поглощение новой строки

        service.getFamilyTree().getChildren(personId);
    }

    private void showParents() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Поглощение новой строки

        service.getFamilyTree().getParents(personId);
    }

    private void saveTree() {
        view.displayMessage("Введите имя файла для сохранения семейного дерева: ");
        String filename = view.getScanner().nextLine();
        service.saveTree(filename);
        view.displayMessage("Семейное дерево сохранено в файл " + filename);
    }

    private void loadTree() {
        view.displayMessage("Введите имя файла для загрузки семейного дерева: ");
        String filename = view.getScanner().nextLine();
        service.loadTree(filename);
        view.displayMessage("Семейное дерево загружено из файла " + filename);
    }

    private void editPerson() {
        Scanner scanner = view.getScanner();
        view.displayMessage("Введите ID человека, которого вы хотите отредактировать: ");
        int personId = scanner.nextInt();
        scanner.nextLine();

        Person person = service.findById(personId);
        if (person == null) {
            view.displayMessage("Член семьи с таким ID не найден.");
            return;
        }

        view.displayPerson(person);

        view.displayMessage("Введите новое имя (оставьте пустым для сохранения текущего): ");
        String firstName = scanner.nextLine();
        if (!firstName.isEmpty()) {
            person.setFirstName(firstName);
        }

        view.displayMessage("Введите новую фамилию (оставьте пустым для сохранения текущей): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            person.setLastName(lastName);
        }

        LocalDate birthDate = ((ConsoleView) view).getDateInput("Введите новую дату рождения (оставьте пустым для сохранения текущей): ");
        if (birthDate != null) {
            person.setBirthDate(birthDate);
        }

        LocalDate deathDate = ((ConsoleView) view).getDateInput("Введите новую дату смерти (оставьте пустым для сохранения текущей): ");
        if (deathDate != null) {
            person.setDeathDate(deathDate);
        }

        Person.Gender gender = ((ConsoleView) view).getGenderInput("Введите новый гендер (оставьте пустым для сохранения текущего): ");
        if (gender != null) {
            person.setGender(gender);
        }

        view.displayMessage("Запись успешно обновлена.");
    }
}
