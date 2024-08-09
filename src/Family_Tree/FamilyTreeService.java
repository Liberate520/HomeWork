package Family_Tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Person> peopleTree;
    private FamilyTree<Animal> animalsTree;

    public FamilyTreeService() {
        this.peopleTree = new FamilyTree<>();
        this.animalsTree = new FamilyTree<>();
    }

    public void loadPeopleFromFile(String fileName) {
        peopleTree.loadFromFile(fileName);
    }

    public void loadAnimalsFromFile(String fileName) {
        animalsTree.loadFromFile(fileName);
    }

    public void savePeopleToFile(String fileName) {
        peopleTree.saveToFile(fileName);
    }

    public void saveAnimalsToFile(String fileName) {
        animalsTree.saveToFile(fileName);
    }

    public void displayPeopleTree() {
        System.out.println("Дерево Людей:");
        System.out.println(peopleTree);
    }

    public void displayAnimalsTree() {
        System.out.println("Дерево Животных:");
        System.out.println(animalsTree);
    }

    public void addPerson(Person person) {
        peopleTree.addElement(person.getName(), person);
    }

    public void addAnimal(Animal animal) {
        animalsTree.addElement(animal.getName(), animal);
    }

    public List<Person> getPeople() {
        return new ArrayList<>(peopleTree.getElements().values());
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animalsTree.getElements().values());
    }

    public Person findPersonByName(String name) {
        return peopleTree.findElementByKey(name);
    }

    public Animal findAnimalByName(String name) {
        return animalsTree.findElementByKey(name);
    }
}
