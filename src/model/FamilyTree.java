package model;

import java.io.Serializable;
import java.util.*;
import model.human.Person;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private Map<String, T> elements;

    public FamilyTree() {
        this.elements = new HashMap<>();
    }

    public void addElement(String name, T element) {
        this.elements.put(name, element);
    }

    public T getElement(String name) {
        return this.elements.get(name);
    }

    @Override
    public Iterator<T> iterator() {
        return this.elements.values().iterator();
    }

    public List<Person> personSortedByName() {
        List<Person> sortedPersons = new ArrayList<>();
        for (T element : elements.values()) {
            if (element instanceof Person) {
                sortedPersons.add((Person) element);
            }
        }
        sortedPersons.sort(Comparator.comparing(Person::getName));
        return sortedPersons;
    }

    public List<Person> personSortedByBirthDay() {
        List<Person> sortedPersons = new ArrayList<>();
        for (T element : elements.values()) {
            if (element instanceof Person) {
                sortedPersons.add((Person) element);
            }
        }
        sortedPersons.sort(Comparator.comparing(Person::getBirthDate));
        return sortedPersons;
    }
}
