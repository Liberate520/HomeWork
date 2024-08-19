package tree;

import human.Human;

import java.util.Comparator;
import java.util.Iterator;

public class HumanComparatorById implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
        Integer intO1 = new Integer(o1.getId());
        Integer intO2 = new Integer(o2.getId());
        return intO1.compareTo(intO2);
    }
}
