package Model.Human;

import Model.FamilyTree.ItemFamilyTree;

import java.util.Comparator;

public class HumanByNameComparator<E extends ItemFamilyTree<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
