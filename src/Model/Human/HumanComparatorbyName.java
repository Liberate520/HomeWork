package Model.Human;

import Model.FamilyTree.FamilyMember;

import java.util.Comparator;

public class HumanComparatorbyName<E extends FamilyMember> implements Comparator<E> {

    public HumanComparatorbyName(){

    }
    @Override
    public int compare(E o1, E o2) {

        return o1.getName().compareTo(o2.getName());
    }
}
