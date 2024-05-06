package family_tree.model.Human;

import family_tree.model.FamilyTree.FamilyTreeElements;

import java.util.Comparator;

public class HumanComparatorByBirthday<E extends FamilyTreeElements<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getDob().compareTo(o2.getDob());
    }
}
