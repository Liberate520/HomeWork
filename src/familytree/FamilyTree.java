package familytree;

import person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(T person) {
        members.add(person);
    }

    public T findPerson(String name) {
        for (T person : members) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public List<T> getAllPersons() {
        return new ArrayList<>(members);
    }

    public void sortByName() {
        members.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        members.sort(Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return members.iterator();
    }
}
