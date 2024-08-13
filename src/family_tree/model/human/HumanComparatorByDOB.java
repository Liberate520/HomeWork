package family_tree.model.human;

import family_tree.model.family_tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByDOB<E extends ItemFamilyTree> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}
