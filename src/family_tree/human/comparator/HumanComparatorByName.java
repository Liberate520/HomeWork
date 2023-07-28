package family_tree.human.comparator;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
