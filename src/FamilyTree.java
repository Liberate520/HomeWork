// Класс FamilyTree - управляет связями между людми и предоставляет методы для проведения исследований.
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

    public List<Person> getChildren(Person parent) {
        List<Person> children = new ArrayList<>();
        for (Person person : people) {
            if (person.getMother() == parent || person.getFather() == parent) {
                children.add(person);
            }
        }
        return children;
    }

    public Person[] getPeople() {
        return people.toArray(new Person[0]);
    }
}
