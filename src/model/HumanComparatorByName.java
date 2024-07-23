package model;

import java.util.Comparator;

public class HumanComparatorByName<T extends FamilyMember<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

