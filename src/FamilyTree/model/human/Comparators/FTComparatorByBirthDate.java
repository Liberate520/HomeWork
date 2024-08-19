package FamilyTree.model.human.Comparators;

import FamilyTree.model.familyTree.ItemFamilyTree;

import java.util.Comparator;

public class FTComparatorByBirthDate<E extends ItemFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}