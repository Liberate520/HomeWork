package human.comparators;

import java.util.Comparator;

import family_tree.FamilyTreeItem;

public class HumanComparatorByGender<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return h1.getGender().compareTo(h2.getGender());
    }
}