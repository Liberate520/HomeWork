package human.comparators;

import java.util.Comparator;

import human.Human;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.getAge(), h2.getAge());
    }

}