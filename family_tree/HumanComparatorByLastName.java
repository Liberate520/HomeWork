package family_tree;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getLastName() == null && o2.getLastName() == null) {
            return 0;
        }
        if (o1.getLastName() == null) {
            return -1;
        }
        if (o2.getLastName() == null) {
            return 1;
        }
        return o1.getLastName().compareTo(o2.getLastName());
    }
}