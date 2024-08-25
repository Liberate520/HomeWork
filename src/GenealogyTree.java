import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GenealogyTree<T extends Person> implements Serializable, Iterable<T> {
    private List<T> persons;

    public GenealogyTree() {
        persons = new ArrayList<>();
    }

    public void addPerson(T person) {
        persons.add(person);
    }

    public void sortByName() {
        persons.sort(Comparator.comparing(Person::getName));
    }

    public void sortByBirthDate() {
        persons.sort(Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public Iterator<T> iterator() {
        return persons.iterator();
    }

    @Override
    public String toString() {
        StringBuilder treeString = new StringBuilder();
        for (T person : persons) {
            treeString.append(person.toString()).append("\n");
        }
        return treeString.toString();
    }
}
