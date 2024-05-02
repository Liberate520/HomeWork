package model.human.comparators;

import model.family_tree.FamilyItem;
import model.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
