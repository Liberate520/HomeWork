package Comparator;

import java.util.Comparator;

import familyTree.FamilyTreeMember;

public class CompareByName<E extends FamilyTreeMember> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
