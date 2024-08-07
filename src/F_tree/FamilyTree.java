package F_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getAllPeople() {
        return people;
    }
}