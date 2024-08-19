package tree;

import human.Human;

import java.util.Comparator;

public class HumanComparatorById implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {
        Integer integerO1 = o1.getId();
        Integer integerO2 = o2.getId();
        return integerO1.compareTo(integerO2);
    }
}
