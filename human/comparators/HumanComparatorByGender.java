package human.comparators;

import java.util.Comparator;

import human.Human;

public class HumanComparatorByGender implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getGender().compareTo(h2.getGender());
    }
}