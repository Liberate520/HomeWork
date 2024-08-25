package presenter;

import service.Service;
import view.TreeView;
import person.Person;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private Service service;
    private TreeView view;

    public Presenter(Service service, TreeView view) {
        this.service = service;
        this.view = view;
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr,
                          String spouseName, List<String> childrenNames, String fatherName, String motherName) {
        service.addPerson(name, birthDate, deathDate, genderStr, spouseName, childrenNames, fatherName, motherName);
        view.displayMessage("Person added successfully.");
    }

    public void findPerson(String name) {
        Person person = service.findPerson(name);
        if (person != null) {
            view.displayPerson(person);
        } else {
            view.displayMessage("Person not found.");
        }
    }

    public void displayAllPersons() {
        List<Person> allPersons = service.getAllPersons();
        view.displayAllPersons(allPersons);
    }

    public void sortByName() {
        service.sortByName();
        view.displayMessage("Family tree sorted by name.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.displayMessage("Family tree sorted by birth date.");
    }

    public void saveTree(String fileName) {
        service.saveTree(fileName);
        view.displayMessage("Family tree saved to " + fileName);
    }

    public void loadTree(String fileName) {
        service.loadTree(fileName);
        view.displayMessage("Family tree loaded from " + fileName);
    }

    public void addRelation(String parentName, String childName) {
        boolean success = service.addRelation(parentName, childName);
        if (success) {
            view.displayMessage("Relation added successfully.");
        } else {
            view.displayMessage("Failed to add relation.");
        }
    }
}
