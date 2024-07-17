package Model.family_tree.human;

import java.util.Comparator;

public class ComparatorByBrthDate<T extends Item> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBrthDate().compareTo(o2.getBrthDate());
    }


}
