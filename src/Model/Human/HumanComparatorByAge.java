package src.Model.Human;

import java.util.Comparator;

import src.Model.FamilyTree.FamilyMember;

public class HumanComparatorByAge<E extends FamilyMember<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
