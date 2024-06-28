import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> persons;

    public FamilyTree() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findPersonByName(String name) {
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    public void printFamilyTree() {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
