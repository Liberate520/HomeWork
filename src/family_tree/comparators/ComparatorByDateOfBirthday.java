package family_tree.comparators;

import family_tree.human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorByDateOfBirthday implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
