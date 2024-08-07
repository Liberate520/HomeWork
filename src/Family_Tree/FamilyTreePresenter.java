package Family_Tree;

import java.time.LocalDate;
import java.util.Map;

public class FamilyTreePresenter {
    private FamilyTree<Family_Tree.Person> model;

    public FamilyTreePresenter(FamilyTree<Family_Tree.Person> model) {
        this.model = model;
    }

    public void addPerson(String firstName, String lastName, int gender, LocalDate birthDate) {
        Family_Tree.Person person = new Family_Tree.Person(firstName, lastName, gender, birthDate);
        model.addElement(person.getName(), person);
    }

    public Family_Tree.Person findPersonByName(String firstName, String lastName) {
        return (Family_Tree.Person) model.findElementByKey(firstName + " " + lastName);
    }

    public void saveToFile(String fileName) {
        model.saveToFile(fileName);
    }

    public void loadFromFile(String fileName) {
        model.loadFromFile(fileName);
    }

    public Map<String, Family_Tree.Person> getPeople() {
        return model.getElements();
    }
}