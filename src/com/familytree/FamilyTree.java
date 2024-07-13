package com.familytree;

import com.familytree.model.Gender;
import com.familytree.model.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private static final long serialVersionUID = 1L;
    
    private Map<String, Human> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public Human addPerson(String name, LocalDate dob, Gender gender) {
        if (!people.containsKey(name)) {
            Human person = new Human(name, dob, gender);
            people.put(name, person);
            return person;
        }
        return people.get(name);
    }

    public Human getPerson(String name) {
        return people.get(name);
    }

    public void setParents(String childName, String motherName, String fatherName) {
        Human child = getPerson(childName);
        Human mother = getPerson(motherName);
        Human father = getPerson(fatherName);

        if (child != null && mother != null) {
            child.setMother(mother);
            mother.addChild(child);
        }

        if (child != null && father != null) {
            child.setFather(father);
            father.addChild(child);
        }
    }

    // Метод для получения всех детей выбранного человека
    public List<Human> getChildren(String personName) {
        Human person = people.get(personName);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<Human> iterator() {
        return people.values().iterator();
    }

    // Методы сортировки
    public List<Human> getPeopleSortedByName() {
        List<Human> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(Human::getName));
        return sortedPeople;
    }

    public List<Human> getPeopleSortedByBirthDate() {
        List<Human> sortedPeople = new ArrayList<>(people.values());
        sortedPeople.sort(Comparator.comparing(Human::getBirthDate));
        return sortedPeople;
    }
}