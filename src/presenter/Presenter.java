package presenter;

import familytree.FamilyTree;
import person.Gender;
import person.Person;
import view.TreeView;

import java.time.LocalDate;

public class Presenter {
    private FamilyTree<Person> familyTree;
    private TreeView view;

    public Presenter(FamilyTree<Person> familyTree, TreeView view) {
        this.familyTree = familyTree;
        this.view = view;
        this.view.setPresenter(this);
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr) {
        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        Person person = new Person(name, birthDate, deathDate, gender);
        familyTree.addPerson(person);
        view.displayMessage("Person added: " + person);
    }

    public void findPerson(String name) {
        Person person = familyTree.findPersonByName(name);
        view.displayPerson(person);
    }

    public void displayAllPersons() {
        view.displayAllPersons(familyTree.toString());
    }

    public void sortByName() {
        familyTree.sortByName();
        view.displayMessage("Tree sorted by name.");
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.displayMessage("Tree sorted by birth date.");
    }
}
