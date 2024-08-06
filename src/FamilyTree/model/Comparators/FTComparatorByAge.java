package FamilyTree.model.Comparators;

import FamilyTree.model.ItemFamilyTree;

import java.util.Comparator;

public class FTComparatorByAge<E extends ItemFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
