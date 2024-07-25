package human;

import java.util.Comparator;
import static java.util.Comparator.*;

public class PersonComparators {
    public static Comparator<Human> compareByName = comparing(Human::getName);
    public static Comparator<Human> compareByAge = comparing(Human::getAge);
}
