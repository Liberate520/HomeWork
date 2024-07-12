package family__tree.human;

import family__tree.family_tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByBirth<T extends ItemFamilyTree> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}
