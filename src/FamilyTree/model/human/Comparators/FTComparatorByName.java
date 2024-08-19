package FamilyTree.model.human.Comparators;

import FamilyTree.model.familyTree.ItemFamilyTree;

import java.util.Comparator;

public class FTComparatorByName<E extends ItemFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}