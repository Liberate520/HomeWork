package familytree.presenter;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.service.FileHandler;
import familytree.service.Research;
import familytree.view.ConsoleView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Person> model;
    private ConsoleView view;
    private FileHandler<Person> fileHandler;

    public FamilyTreePresenter(FamilyTree<Person> model, ConsoleView view) {
        this.model = model;
        this.view = view;
        this.fileHandler = new FileHandler<>();
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
        Person person = view.getPersonInfo();
        model.addMember(person);
        view.showMessage("Person added successfully.");
    }

    private void showAllPeople() {
        view.showPeople(model.getMembers());
    }

    private void findChildren() {
        String name = view.getPersonName();
        Person person = findPersonByName(name);
        if (person != null) {
            List<Person> children = Research.findChildren(person);
            view.showChildren(children);
        } else {
            view.showMessage("Person not found.");
        }
    }

    private Person findPersonByName(String name) {
        for (Person person : model) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    private void sortByName() {
        model.sortByName();
        view.showMessage("Family tree sorted by name.");
        showAllPeople();
    }

    private void sortByBirthDate() {
        model.sortByBirthDate();
        view.showMessage("Family tree sorted by birth date.");
        showAllPeople();
    }

    private void saveToFile() {
        String fileName = view.getFileName();
        try {
            fileHandler.save(model, fileName);
            view.showMessage("Family tree saved successfully.");
        } catch (Exception e) {
            view.showMessage("Error saving family tree: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        String fileName = view.getFileName();
        try {
            FamilyTree<Person> loadedTree = fileHandler.load(fileName);
            model = loadedTree;
            view.showMessage("Family tree loaded successfully.");
        } catch (Exception e) {
            view.showMessage("Error loading family tree: " + e.getMessage());
        }
    }
}