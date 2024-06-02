import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<String, Person> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public List<Person> getChildren(String name) {
        Person person = people.get(name);
        if (person != null) {
            return person.getChildren();
        } else {
            return null;
        }
    }

    public void printFamilyTree() {
        for (Person person : people.values()) {
            if (person.getFather() == null && person.getMother() == null) {
                printPersonAndChildren(person, 0);
            }
        }
    }

    private void printPersonAndChildren(Person person, int level) {
        String indent = " ".repeat(level * 4);
        System.out.println(indent + person);
        for (Person child : person.getChildren()) {
            printPersonAndChildren(child, level + 1);
        }
    }
}
