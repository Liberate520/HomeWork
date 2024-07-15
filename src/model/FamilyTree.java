package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    @Serial
    private static final long serialVersionUID = 1L;
    private final List<Person> people;
    private int nextId;

    public FamilyTree() {
        this.people = new ArrayList<>();
        this.nextId = 1;
    }

    public void addPerson(Person person) {
        this.people.add(person);
        this.nextId++;
    }

    public int generateId() {
        return nextId;
    }

    public Person findPersonById(int id) {
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildren(Person person) {
        return person.getChildren();
    }

    public void createNewTree() {
        this.people.clear();
        this.nextId = 1;
    }

    public List<Person> getAllPeople() {
        return new ArrayList<>(people);
    }

    public void sortByName() {
        people.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        people.sort(Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }
}
