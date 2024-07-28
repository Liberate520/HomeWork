package group.model.comparators;

import group.model.Dogs;

import java.util.Comparator;

public class FamilyTreeComparatorByDeath <T extends Dogs> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge()-o2.getAge();
    }
}
