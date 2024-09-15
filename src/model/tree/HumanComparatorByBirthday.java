package model.tree;

import java.util.Comparator;

public class HumanComparatorByBirthday<T extends TreeConn<T>> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
