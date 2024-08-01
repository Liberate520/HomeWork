package familytree;

import person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.members.add(person);
    }

    public Person findPerson(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildren(String name) {
        Person person = findPerson(name);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }

    public List<Person> getParents(String name) {
        Person person = findPerson(name);
        if (person != null) {
            return person.getParents();
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FamilyTree:\n");
        for (Person person : members) {
            sb.append(person.toString()).append("\n");
        }
        return sb.toString();
    }
}
