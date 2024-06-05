package src.family_tree.Iterator;

import src.family_tree.Human;

import java.util.Comparator;
import java.util.HashMap;

public class ComparatorName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
