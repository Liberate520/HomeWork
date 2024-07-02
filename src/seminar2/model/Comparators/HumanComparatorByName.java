package seminar2.model.Comparators;

import seminar2.model.Human.Creature;

import java.util.Comparator;

public class HumanComparatorByName<T extends Creature<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
