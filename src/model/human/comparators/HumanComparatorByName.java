package model.human.comparators;

import model.family_tree.FamilyItem;
import model.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

}