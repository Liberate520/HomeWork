package Family_Tree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTreeService {
    private Map<String, Person> people;
    private Map<String, Animal> animals;
    private FileIOInterface<Map<String, Person>> peopleFileIO;
    private FileIOInterface<Map<String, Animal>> animalsFileIO;

    public FamilyTreeService() {
        this.people = new HashMap<>();
        this.animals = new HashMap<>();
        this.peopleFileIO = new FileIO<>();
        this.animalsFileIO = new FileIO<>();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public void addAnimal(Animal animal) {
        animals.put(animal.getName(), animal);
    }

    public Person findPersonByName(String name) {
        return people.get(name);
    }

    public Animal findAnimalByName(String name) {
        return animals.get(name);
    }

    public void savePeopleToFile(String fileName) {
        peopleFileIO.writeToFile(fileName, people);
    }

    public void saveAnimalsToFile(String fileName) {
        animalsFileIO.writeToFile(fileName, animals);
    }

    public void loadPeopleFromFile(String fileName) {
        people = peopleFileIO.readFromFile(fileName);
    }

    public void loadAnimalsFromFile(String fileName) {
        animals = animalsFileIO.readFromFile(fileName);
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    public Map<String, Animal> getAnimals() {
        return animals;
    }
}