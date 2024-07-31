package Family_Tree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable {
    private Map<String, Person> people;
    private FileIOInterface<FamilyTree> fileIO; // Исправлено на FileIOInterface<FamilyTree>

    public FamilyTree() {
        this.people = new HashMap<>();
        this.fileIO = new FileIO<>(); // Исправлено на FileIO<>
    }

    public void addPerson(Person person) { // Исправлено на addPerson
        people.put(person.getName(), person);
    }

    public Person findPersonByName(String name) {
        return people.get(name);
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, this); // Исправлено на передачу объекта FamilyTree
    }

    public void loadFromFile(String fileName) {
        FamilyTree loadedTree = fileIO.readFromFile(fileName);
        if (loadedTree != null) {
            this.people = loadedTree.getPeople();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : people.values()) {
            sb.append(person.toString()).append("\
");
        }
        return sb.toString();
    }
}