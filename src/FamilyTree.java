import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<Integer, Person> people;

    public FamilyTree() {
        this.people = new HashMap<>();
    }

    public void addPerson(Person person) {
        people.put(person.getId(), person);
    }

    public Person getPerson(int id) {
        return people.get(id);
    }

    public List<Person> getAllPeople() {
        return new ArrayList<>(people.values());
    }

    public List<Person> findByName(String firstName, String lastName) {
        List<Person> results = new ArrayList<>();
        for (Person person : people.values()) {
            if (person.getFirstName().equalsIgnoreCase(firstName) ||
                    person.getLastName().equalsIgnoreCase(lastName)) {
                results.add(person);
            }
        }
        return results;
    }

    public void setParents(int childId, int motherId, int fatherId) {
        Person child = getPerson(childId);
        Person mother = getPerson(motherId);
        Person father = getPerson(fatherId);

        if (child != null) {
            child.setMother(mother);
            child.setFather(father);
            if (mother != null) {
                mother.addChild(child);
            }
            if (father != null) {
                father.addChild(child);
            }
        }
    }

    public void getChildren(int personId) {
        Person person = getPerson(personId);
        if (person != null) {
            System.out.println("Дети " + person.getFirstName() + " " + person.getLastName() + ":");
            for (Person child : person.getChildren()) {
                System.out.println(child);
            }
        }
    }

    public void getParents(int personId) {
        Person person = getPerson(personId);
        if (person != null) {
            System.out.println("Родители " + person.getFirstName() + " " + person.getLastName() + ":");
            if (person.getMother() != null) {
                System.out.println("Мать: " + person.getMother());
            } else {
                System.out.println("Мать: не указано");
            }
            if (person.getFather() != null) {
                System.out.println("Отец: " + person.getFather());
            } else {
                System.out.println("Отец: не указано");
            }
        }
    }
}