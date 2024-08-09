package Family_Tree;

import java.time.LocalDate;
import java.util.Collection;

public class FamilyTreePresenter {
    private FamilyTree<Person> model;
    private FamilyTreeConsoleView view;

    public FamilyTreePresenter(FamilyTree<Person> model, FamilyTreeConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void addPerson(String firstName, String lastName, int gender, LocalDate birthDate) {
        Person person = new Person(firstName, lastName, gender, birthDate);
        model.addElement(person.getName(), person);
        view.displayPersonAdded(person);
    }

    public Person findPersonByName(String firstName, String lastName) {
        return model.findElementByKey(firstName + " " + lastName);
    }

    public void saveToFile(String fileName) {
        model.saveToFile(fileName);
        view.displayFileSaved(fileName);
    }

    public void loadFromFile(String fileName) {
        model.loadFromFile(fileName);
        view.displayFileLoaded(fileName);
    }

    public Collection<Person> getPeople() {
        return model.getElements().values();
    }

    // Добавить новые методы для расширения функциональности
    public void addNewFeature() {
        // Реализация нового функционала
        model.addNewFeature("key", new Person("John", "Doe", Person.MALE, LocalDate.now()));
        view.displayNewFeature();
    }
}