package family_tree.human.comparators;

// import family_tree.human.Human;
import family_tree.family_tree.*;

import java.util.Comparator;

public class HumanComparatorByBirthDate<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
