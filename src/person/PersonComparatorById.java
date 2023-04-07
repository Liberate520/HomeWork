package person;
import java.util.Comparator;

public class PersonComparatorById implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getId(), o2.getId());

    }
}