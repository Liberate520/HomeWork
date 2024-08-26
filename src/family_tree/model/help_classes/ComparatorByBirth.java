package family_tree.model.help_classes;

import family_tree.model.program_classes.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByBirth<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o2.getBirthDate().compareTo(o1.getBirthDate());

    }
}
