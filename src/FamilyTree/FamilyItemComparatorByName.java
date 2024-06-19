package FamilyTree;

import Human.Human;

import java.util.Comparator;

public class FamilyItemComparatorByName<T extends FamilyItem> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
