package family_tree;

import java.util.Comparator;

import human.Human;

public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getLastName() == null && o2.getLastName() == null) {
            return 0;
        }
        if (o1.getLastName() == null) {
            return -1;
        }
        if (o2.getLastName() == null) {
            return 1;
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}