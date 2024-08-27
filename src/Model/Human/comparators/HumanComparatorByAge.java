package Model.Human.comparators;

import Model.FamilyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getAgeInfo() - o2.getAgeInfo();
    }
}
