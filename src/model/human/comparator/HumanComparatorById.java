package model.human.comparator;


import model.human.Element;

import java.util.Comparator;

public class HumanComparatorById<T extends Element> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getID(), o2.getID());
    }
}
