package seminar2.model.Comparators;

import seminar2.model.Human.Creature;

import java.util.Comparator;

public class HumanComparatorByChildren<T extends Creature<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
