package man.comparator;

import family_tree.FamilyTreeItem;
import man.Man;

import java.util.Comparator;

public class ItemComparatorByName <E extends FamilyTreeItem> implements Comparator <E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
