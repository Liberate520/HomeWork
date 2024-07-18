package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void displayTree() {
        for (Person person : people) {
            displayPerson(person, 0);
        }
    }

    private void displayPerson(Person person, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(person.getName());
        for (Person child : person.getChildren()) {
            displayPerson(child, level + 1);
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    // Methods for sorting
    public void sortByName() {
        people.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        people.sort(Comparator.comparing(Person::getBirthDate));
    }

    public void addNode(Person person) {

    }
}
