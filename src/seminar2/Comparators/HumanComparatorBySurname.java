package seminar2.Comparators;

import seminar2.Human.Human;

import java.util.Comparator;

public class HumanComparatorBySurname implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
