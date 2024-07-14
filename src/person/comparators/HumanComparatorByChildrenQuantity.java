package person.comparators;

import person.Human;

import java.util.Comparator;

public class HumanComparatorByChildrenQuantity implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getChildrenQuantity().compareTo(o2.getChildrenQuantity());
    }
}
