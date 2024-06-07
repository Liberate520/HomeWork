package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Person> {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(Person person) {
        this.members.add(person);
    }

    public List<Person> getChildrenOf(Person parent) {
        return parent.getChildren();
    }

    public Person findPersonByName(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }

    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Person::getName));
    }

    public void sortByAge() {
        Collections.sort(members, Comparator.comparingInt(Person::getAge));
    }

    @Override
    public Iterator<Person> iterator() {
        return members.iterator();
    }
}

