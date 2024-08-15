package presenter;

import service.Service;
import view.TreeView;
import person.Person;

import java.time.LocalDate;

public class Presenter {
    private Service service;
    private TreeView view;

    public Presenter(Service service, TreeView view) {
        this.service = service;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr) {
        service.addPerson(name, birthDate, deathDate, genderStr);
        view.displayMessage("Person added successfully.");
    }

    public void findPerson(String name) {
        view.displayPerson(String.valueOf(service.findPerson(name)));
    }

    public void displayAllPersons() {
        view.displayAllPersons(service.getAllMembers());
    }

    public void sortByName() {
        service.sortByName();
        view.displayMessage("Tree sorted by name.");
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.displayMessage("Tree sorted by birth date.");
    }

    public void saveTree(String fileName) {
        service.saveTree(fileName);
        view.displayMessage("Tree saved to file: " + fileName);
    }

    public void loadTree(String fileName) {
        service.loadTree(fileName);
        view.displayMessage("Tree loaded from file: " + fileName);
    }
}
