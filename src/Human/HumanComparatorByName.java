package src.Human;

import java.util.Comparator;

import src.FamilyTree.FamilyMember;

public class HumanComparatorByName<E extends FamilyMember<E>> implements Comparator <E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }    
}
