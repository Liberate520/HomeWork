package src.family_tree.Iterator;

import src.family_tree.Human;

import java.util.Comparator;

public class ComparatorBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}
