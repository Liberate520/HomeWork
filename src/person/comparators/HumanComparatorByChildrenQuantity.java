package person.comparators;

import familyTreeSrc.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByChildrenQuantity<T extends ItemFamilyTree<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getChildrenQuantity().compareTo(o2.getChildrenQuantity());
    }
}
