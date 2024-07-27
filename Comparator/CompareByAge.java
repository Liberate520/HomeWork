package Comparator;

import java.util.Comparator;

import familyTree.FamilyTreeMember;

public class CompareByAge<E extends FamilyTreeMember> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}