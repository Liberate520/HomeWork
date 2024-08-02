package model;

import model.human.*;
import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
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

    public List<T> personSortedByName() {
        List<T> sortedPersons = new ArrayList<>(elements.values());
        sortedPersons.sort(Comparator.comparing(Person::getName));
        return sortedPersons;
    }

    public List<T> personSortedByBirthDay() {
        List<T> sortedPersons = new ArrayList<>(elements.values());
        sortedPersons.sort(Comparator.comparing(Person::getBirthDate));
        return sortedPersons;
    }
}
