import java.util.ArrayList;
import java.util.List;

class GenealogyTree {
    private final List<Person> people;

    public GenealogyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getChildren(Person person) {
        return person.getChildren();
    }

}

