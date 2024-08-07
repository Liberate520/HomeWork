package model.human.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByBirthDate<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
