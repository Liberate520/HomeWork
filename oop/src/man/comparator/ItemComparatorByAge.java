package man.comparator;

import family_tree.FamilyTreeItem;
import man.Man;

import java.util.Comparator;

public class ItemComparatorByAge <E extends FamilyTreeItem> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(),o2.getAge());
    }
}
