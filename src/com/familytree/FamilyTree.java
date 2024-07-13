package com.familytree;

import com.familytree.model.FamilyMember;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends FamilyMember<T>> implements Serializable, Iterable<T> {
    private Map<String, T> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(T person) {
        people.put(person.getName(), person);
    }

    public T getPerson(String name) {
        return people.get(name);
    }

    public void setParents(String childName, String motherName, String fatherName) {
        T child = getPerson(childName);
        T mother = getPerson(motherName);
        T father = getPerson(fatherName);

        if (child != null && mother != null) {
            child.setMother(mother);
            mother.addChild(child);
        }

        if (child != null && father != null) {
            child.setFather(father);
            father.addChild(child);
        }
    }

    public List<T> getChildren(String personName) {
        T person = people.get(personName);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return people.values().iterator();
    }

    public List<T> getPeopleSortedByName() {
        List<T> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(T::getName));
        return sortedPeople;
    }

    public List<T> getPeopleSortedByBirthDate() {
        List<T> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(T::getBirthDate));
        return sortedPeople;
    }
}