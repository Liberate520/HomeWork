package familytree.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Comparator;
import java.util.Iterator;

public class FamilyTree implements Serializable, Iterable<Person> {
    private static final long serialVersionUID = 1L;
    private Map<FullName, Person> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addPerson(Person person) {
        members.put(person.getFullName(), person);
    }

    public Person findPersonByFullName(String familyName, String firstName, String fatherName) {
        return members.get(new FullName(familyName, firstName, fatherName));
    }

    public List<Person> findChildrenByFullName(String familyName, String firstName, String fatherName) {
        Person person = findPersonByFullName(familyName, firstName, fatherName);
        if (person != null) {
            return person.getChildren();
        }
        return new ArrayList<>();
    }

    public void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                           String childFamilyName, String childFirstName, String childFatherName) {
        Person parent = findPersonByFullName(parentFamilyName, parentFirstName, parentFatherName);
        Person child = findPersonByFullName(childFamilyName, childFirstName, childFatherName);
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
        }
    }

    @Override
    public Iterator<Person> iterator() {
        return members.values().iterator();
    }

    public List<Person> getSortedByName() {
        List<Person> sortedList = new ArrayList<>(members.values());
        sortedList.sort(Comparator.comparing(p -> p.getFullName().getFirstName()));
        return sortedList;
    }

    public List<Person> getSortedByDateOfBirth() {
        List<Person> sortedList = new ArrayList<>(members.values());
        sortedList.sort(Comparator.comparing(Person::getDateOfBirth));
        return sortedList;
    }
}