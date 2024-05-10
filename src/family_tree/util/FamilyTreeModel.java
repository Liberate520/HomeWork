package family_tree.util;

import family_tree.person.Person;

import java.util.HashMap;
import java.util.Map;

public class FamilyTreeModel {
    private final Map<Integer, Person> familyTree;

    public FamilyTreeModel() {
        this.familyTree = new HashMap<>();
    }

    public Person getPerson(int id) {
        return familyTree.get(id);
    }

    public void addPerson(int id, Person person) {
        familyTree.put(id, person);
    }

    public void removePerson(int id) {
        familyTree.remove(id);
    }

    public Map<Integer, Person> getAllPeople() {
        return familyTree;
    }
}
