package model.persons.person_manager;

import model.persons.Person;
import model.persons.Gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonRelations implements Serializable {
    private final Person person;

    public PersonRelations(Person person) {
        this.person = person;
    }

    public boolean addChild(Person child) {
        if (!person.getChildren().contains(child)) {
            person.getChildren().add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Person parent) {
        if (parent.getGender() == Gender.MALE) {
            person.setFather(parent);
        } else if (parent.getGender() == Gender.FEMALE) {
            person.setMother(parent);
        }
        return true;
    }

    public List<Person> getParents() {
        List<Person> parents = new ArrayList<>();
        if (person.getMother() != null) {
            parents.add(person.getMother());
        }
        if (person.getFather() != null) {
            parents.add(person.getFather());
        }
        return parents;
    }
}
