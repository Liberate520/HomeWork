package ru.gb.family_tree.model.item.comparators;

import java.util.Comparator;

import ru.gb.family_tree.model.item.FamilyTreeItem;

public class ItemComparatorBySpouse<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
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