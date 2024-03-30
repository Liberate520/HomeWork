package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeEntity> implements Serializable, Iterable<T> {

    private List<T> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(T person) {
        people.add(person);
    }

    public void addRelationship(String parentName, String childName) {
        T parent = findPerson(parentName);
        T child = findPerson(childName);

        if (parent != null && child != null) {
            parent.addChild(child);
            if (parent.getGender().equals(Gender.Male)){
                child.setFather((Person) parent); // Приведение к Person
            } else {
                child.setMother((Person) parent); // Приведение к Person
            }
        } else {
            System.out.println("Person not found in the family tree.");
        }
    }

    public List<? extends FamilyTreeEntity> getChildrenOfPerson(String name) {
        T person = findPerson(name);
        if (person != null) {
            return person.getChildren();
        } else {
            System.out.println("Person not found in the family tree.");
            return new ArrayList<>();
        }
    }

    private T findPerson(String name) {
        for (T person : people) {
            String personName = person.getName();
            if (personName != null && personName.equals(name)) {
                return person;
            }
        }
        return null;
    }

    public void sortByName() {
        Collections.sort(people, new Comparator<T>() {
            @Override
            public int compare(T person1, T person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });
    }

    public void sortByDateOfBirth() {
        Collections.sort(people, new Comparator<T>() {
            @Override
            public int compare(T person1, T person2) {
                return person1.getBirthYear().compareTo(person2.getBirthYear());
            }
        });
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "people=" + people +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return people.iterator();
    }
}
