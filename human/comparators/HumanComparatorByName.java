package human.comparators;

import java.util.Comparator;

import family_tree.FamilyTreeItem;

public class HumanComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return h1.getName().compareTo(h2.getName());
    }

}