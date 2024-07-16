package person.comparators;

import familyTreeSrc.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByAge<T extends ItemFamilyTree<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
