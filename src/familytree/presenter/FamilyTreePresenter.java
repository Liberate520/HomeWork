package familytree.presenter;

import familytree.model.Person;
import familytree.model.Gender;
import familytree.service.FamilyTreeService;
import familytree.view.ConsoleView;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private ConsoleView view;

    public FamilyTreePresenter(FamilyTreeService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    showAllPeople();
                    break;
                case 3:
                    findChildren();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    sortByBirthDate();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 0:
                    return;
                default:
                    view.showMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void addPerson() {
        String name = view.getPersonName();
        LocalDate birthDate = view.getPersonBirthDate();
        String gender = view.getPersonGender();
        Person person = new Person(name, birthDate, Gender.valueOf(gender));
        service.addPerson(person);
        view.showMessage("Person added successfully.");
    }

    private void showAllPeople() {
        List<Person> people = service.getAllPeople();
        view.showPeople(people);
    }

    private void findChildren() {
        String name = view.getPersonName();
        List<Person> children = service.findChildren(name);
        view.showChildren(children);
    }

    private void sortByName() {
        service.sortByName();
        view.showMessage("Family tree sorted by name.");
        showAllPeople();
    }

    private void sortByBirthDate() {
        service.sortByBirthDate();
        view.showMessage("Family tree sorted by birth date.");
        showAllPeople();
    }

    private void saveToFile() {
        String fileName = view.getFileName();
        try {
            service.saveToFile(fileName);
            view.showMessage("Family tree saved successfully.");
        } catch (Exception e) {
            view.showMessage("Error saving family tree: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        String fileName = view.getFileName();
        try {
            service.loadFromFile(fileName);
            view.showMessage("Family tree loaded successfully.");
        } catch (Exception e) {
            view.showMessage("Error loading family tree: " + e.getMessage());
        }
    }
}