package human.comparators;

import familytree.FamilyTreeElement;
import human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeElement> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
