import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
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
}
