package com.example.genealogy.model;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import com.example.genealogy.model.relationships.Relationship;


public class GenealogyTreeModel {

    private Person rootPerson;
    private List<Person> people;

    public GenealogyTreeModel() {
        this.rootPerson = null;
        this.people = new ArrayList<>();
    }

    public GenealogyTreeModel(Person rootPerson) {
        this.rootPerson = rootPerson;
        this.people = new ArrayList<>();
        this.people.add(rootPerson);
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public void addPerson(String name) {
        Person person = new Person(name, null);
        this.people.add(person);
    }

    public void removePerson(String name) {
        for (Person person : this.people) {
            if (person.getName().equals(name)) {
                this.people.remove(person);
                return;
            }
        }
    }

    public void addRelationship(String person1, String person2, String relationship) {
        Person p1 = findPersonByName(person1);
        Person p2 = findPersonByName(person2);

        if (p1 != null && p2 != null) {
            p1.addRelationship(p2, relationship);
            p2.addRelationship(p1, relationship);
        }
    }

    public void removeRelationship(String person1, String person2) {
        Person p1 = findPersonByName(person1);
        Person p2 = findPersonByName(person2);

        if (p1 != null && p2 != null) {
            p1.removeRelationship(p2);
            p2.removeRelationship(p1);
        }
    }

    public void printTree() {
        printTree(rootPerson, "");
    }

    private void printTree(Person person, String indent) {
        System.out.println(indent + person.getName());

        for (Relationship relationship : person.getRelationships()) {
            System.out.println(indent + "  " + relationship.getPerson1().getName() + " (" + relationship.getType() + ")");
            printTree(relationship.getPerson1(), indent + "  ");
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getRootPerson() {
        return rootPerson;
    }

    private Person findPersonByName(String name) {
        for (Person person : this.people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    public void saveTree(GenealogyTreeModel genealogyTree, String filename) { 
        
    }
    
    public void sortByName() {
        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, (p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()));
    }
}
