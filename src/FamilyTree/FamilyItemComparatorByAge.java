package FamilyTree;

import Human.Human;

import java.util.Comparator;

public class FamilyItemComparatorByAge<T extends FamilyItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
