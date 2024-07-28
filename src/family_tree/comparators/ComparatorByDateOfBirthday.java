package family_tree.comparators;

import family_tree.Interface.Animal;
import family_tree.human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorByDateOfBirthday<E extends Animal<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
