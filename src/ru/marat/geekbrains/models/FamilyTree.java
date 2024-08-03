package ru.marat.geekbrains.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Person> {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getChildren(Person parent) {
        List<Person> children = new ArrayList<>();
        for (Person person : people) {
            if (person.getMother() == parent || person.getFather() == parent) {
                children.add(person);
            }
        }
        return children;
    }

    public void sortByName() {
        Collections.sort(people, Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(people, Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<Person> iterator() {
        return people.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }
}
