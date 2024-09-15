package model.tree;

import java.util.Comparator;

public class HumanComparatorById<T extends TreeConn<T>> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        Integer integerO1 = o1.getId();
        Integer integerO2 = o2.getId();
        return integerO1.compareTo(integerO2);
    }
}
