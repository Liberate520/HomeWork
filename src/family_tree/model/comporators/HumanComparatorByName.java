package family_tree.model.comporators;

import family_tree.model.humanTree.ItemHumanTree;

import java.util.Comparator;

public class HumanComparatorByName<T extends ItemHumanTree> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
