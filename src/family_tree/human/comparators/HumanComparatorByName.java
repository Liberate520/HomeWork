package family_tree.human.comparators;

import family_tree.family_tree1.ItemFamilyTree;
import java.util.Comparator;

public class HumanComparatorByName<E extends ItemFamilyTree> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
