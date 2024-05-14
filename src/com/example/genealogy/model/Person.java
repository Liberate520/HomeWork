package com.example.genealogy.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.genealogy.model.relationships.Relationship;

public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private Person parent;
    private List<Relationship> relationships;

    public Person(String name, Person parent) {
        this.name = name;
        this.dateOfBirth = LocalDate.now();
        this.parent = parent;
        this.relationships = new ArrayList<>();
    }

    public void addRelationship(Person person, String relationship) {
        Relationship newRelationship = new Relationship(this, person, relationship);
        this.relationships.add(newRelationship);
        person.addRelationship(this, relationship);
    }

    public void removeRelationship(Person person) {
        for (Relationship relationship : this.relationships) {
            if (relationship.getPerson1().equals(person)) {
                this.relationships.remove(relationship);
                person.removeRelationship(this);
                return;
            }
        }
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Person getParent() {
        return parent;
    }
}