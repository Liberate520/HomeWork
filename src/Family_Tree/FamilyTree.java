package Family_Tree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Person> {
    private Map<String, Person> people;
    private FileIOInterface fileIO;

    public FamilyTree() {
        this.people = new HashMap<>();
        this.fileIO = new FileIO();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public Person findPersonByName(String name) {
        return people.get(name);
    }

    public Map<String, Person> getPeople() {
        return people;
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, this);
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
        List<Person> sortedPeople = sortPeopleByName(new ArrayList<>(people.values()));
        for (Person person : sortedPeople) {
            sb.append(person.toString()).append("\
");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.values().iterator();
    }

    private List<Person> sortPeopleByName(List<Person> peopleList) {
        peopleList.sort(Comparator.comparing(Person::getName));
        return peopleList;
    }

    private List<Person> sortPeopleByBirthDate(List<Person> peopleList) {
        peopleList.sort(Comparator.comparing(Person::getBirthDate));
        return peopleList;
    }
}
