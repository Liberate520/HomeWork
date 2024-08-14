package family_tree.help_classes;

import java.util.Comparator;

public class ComparatorByBirth<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());

    }
}
