package family_tree.model.human.comparators;

import family_tree.model.family_tree1.ItemFamilyTree;
import java.util.Comparator;

public class HumanComparatorByDateBirth<E extends ItemFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}
