package family_tree.humans.comparators;

import family_tree.humans.Human;

import javax.xml.crypto.Data;
import java.util.Comparator;

public class HumanComparatorByBurthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
