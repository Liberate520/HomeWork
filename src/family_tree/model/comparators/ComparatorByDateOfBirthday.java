package family_tree.model.comparators;

import family_tree.model.Interface.Animal;

import java.util.Comparator;

public class ComparatorByDateOfBirthday<E extends Animal<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
