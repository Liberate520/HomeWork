package human.comparator;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByCildrenNumber   implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getChildrenListSize(), o2.getChildrenListSize());
    }
}