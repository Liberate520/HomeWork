package tree.human.comparators;

import java.util.Comparator;

import tree.human.Human;

public class HumanComparatorByAge implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
