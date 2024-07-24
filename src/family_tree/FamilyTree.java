package family_tree;

import human.Person;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Person> {
    private Map<String, Person> persons;

    public FamilyTree() {
        this.persons = new HashMap<>();
    }

    public void addPerson(Person person) {
        this.persons.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return this.persons.get(name);
    }

    public List<Person> getChildren(String name) {
        Person person = this.persons.get(name);
        if (person != null) {
            return person.getChildren();
        }
        return null;
    }

    public  List<Person> PersonSortedByName() {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Comparator.comparing(Person::getName));

        return sortedPersons;
    }

    public  List<Person> PersonsSortedByBirthDay() {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Comparator.comparing(Person::getAge));

        return sortedPersons;
    }

    @Override
    public Iterator<Person> iterator() {
        return this.persons.values().iterator();
    }

}
