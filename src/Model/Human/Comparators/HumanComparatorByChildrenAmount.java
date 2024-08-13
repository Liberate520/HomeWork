package src.Model.Human.Comparators;

import java.util.Comparator;

import src.Model.FamilyTree.FamilyMember;

public class HumanComparatorByChildrenAmount<E extends FamilyMember<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getChildren().size() - o2.getChildren().size();
    }
}
