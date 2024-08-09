package Family_Tree;

import java.time.LocalDate;
import java.util.Collection;

public class FamilyTreePresenter {
    private FamilyTree<Person> peopleTree;
    private FamilyTree<Animal> animalsTree;
    private FamilyTreeConsoleView view;

    public FamilyTreePresenter(FamilyTree<Person> peopleTree, FamilyTree<Animal> animalsTree, FamilyTreeConsoleView view) {
        this.peopleTree = peopleTree;
        this.animalsTree = animalsTree;
        this.view = view;
    }

    public void addPerson(String firstName, String lastName, int gender, LocalDate birthDate) {
        Person person = new Person(firstName, lastName, gender, birthDate);
        peopleTree.addElement(person.getName(), person);
        view.displayPersonAdded(person);
    }

    public void addAnimal(String name, String breed, LocalDate birthDate) {
        Animal animal = new Dog(name, breed, birthDate);
        animalsTree.addElement(animal.getName(), animal);
        view.displayAnimalAdded(animal);
    }

    public Person findPersonByName(String firstName, String lastName) {
        return peopleTree.findElementByKey(firstName + " " + lastName);
    }

    public Animal findAnimalByName(String name) {
        return animalsTree.findElementByKey(name);
    }

    public void saveToFile(String fileName) {
        peopleTree.saveToFile(fileName);
        animalsTree.saveToFile(fileName);
        view.displayFileSaved(fileName);
    }

    public void loadFromFile(String fileName) {
        peopleTree.loadFromFile(fileName);
        animalsTree.loadFromFile(fileName);
        view.displayFileLoaded(fileName);
    }

    public Collection<Person> getPeople() {
        return peopleTree.getElements().values();
    }

    public Collection<Animal> getAnimals() {
        return animalsTree.getElements().values();
    }
}