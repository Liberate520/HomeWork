package Model.family_tree.human;

import Model.family_tree.Item;

import java.util.Comparator;

public class ComporatorById<T extends Item>implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
