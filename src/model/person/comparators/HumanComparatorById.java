package model.person.comparators;

import model.familyTreeSrc.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorById<T extends ItemFamilyTree<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}
