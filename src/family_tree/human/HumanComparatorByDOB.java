package family_tree.human;

import family_tree.family_tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByDOB<E extends ItemFamilyTree> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}
