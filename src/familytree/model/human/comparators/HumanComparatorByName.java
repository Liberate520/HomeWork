package familytree.model.human.comparators;

import familytree.model.familytree.FamilyTreeElement;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyTreeElement<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
