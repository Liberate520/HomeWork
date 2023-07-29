package ru.geekbrains.family_tree.comparators;

import java.util.Comparator;

import ru.geekbrains.family_tree.family_tree.FamilyMember;

public class FamilyMemberByNameComparator<E extends FamilyMember> implements Comparator<E> {

    @Override
    public int compare(E familyMember1, E familyMember2) {
        return familyMember1.getName().compareTo(familyMember2.getName());
    }
    
}
