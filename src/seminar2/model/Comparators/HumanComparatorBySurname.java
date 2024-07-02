package seminar2.model.Comparators;

import seminar2.model.Human.Creature;

import java.util.Comparator;

public class HumanComparatorBySurname<T extends Creature> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
