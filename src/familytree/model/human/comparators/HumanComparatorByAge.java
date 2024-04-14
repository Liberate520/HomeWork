package familytree.model.human.comparators;

import familytree.model.familytree.FamilyTreeElement;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeElement<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
