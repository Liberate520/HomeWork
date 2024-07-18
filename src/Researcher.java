import java.util.ArrayList;
import java.util.List;

public class Researcher {
    public List<Person> getDescendants(Person person) {
        List<Person> descendants = new ArrayList<>();
        collectDescendants(person, descendants);
        return descendants;
    }

    private void collectDescendants(Person person, List<Person> descendants) {
        if (person == null) return;
        for (Person child : person.getChildren()) {
            descendants.add(child);
            collectDescendants(child, descendants);
        }
    }
}
