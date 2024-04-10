package src.human.comparators;

import src.familyTree.FamilyTreeElement;
import src.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeElement> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}