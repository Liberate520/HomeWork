package FamilyTree.Tree.Comparators;

import FamilyTree.Tree.HumanGroup.Human.Human;
import FamilyTree.Tree.HumanGroup.HumanGroupItem;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
