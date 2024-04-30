package FamilyTree;

import Human.Methods;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends Methods<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
