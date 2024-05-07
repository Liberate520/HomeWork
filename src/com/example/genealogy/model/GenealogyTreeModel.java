package com.example.genealogy.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenealogyTreeModel {

    private Person rootPerson;
    private List<Person> people;

    public GenealogyTreeModel(Person rootPerson) {
        this.rootPerson = rootPerson;
        this.people = new ArrayList<>();
        this.people.add(rootPerson);
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public void sortByName() {
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, (p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));
    }

    public Person getRootPerson() {
        return rootPerson;
    }

}
