package Human.comparators;

import FamilyTree.FamilyTreeItem;
import Human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getAgeInfo() - o2.getAgeInfo();
    }
}
