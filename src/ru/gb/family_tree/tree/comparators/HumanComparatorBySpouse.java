package ru.gb.family_tree.tree.comparators;

import java.util.Comparator;
import ru.gb.family_tree.human.Human;

public class HumanComparatorBySpouse implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        // return o1.getSpouse().compareTo(o2.getSpouse());
        if ((o1.getSpouse() == null) && (o2.getSpouse() == null)) {
            return o1.getName().compareTo(o2.getName()) - 1;
        } else if (o1.getSpouse() == null) {
            return -1;
        } else {
            return 1;
        }
    }
}