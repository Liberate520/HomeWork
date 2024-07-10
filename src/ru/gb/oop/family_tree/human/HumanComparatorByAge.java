package ru.gb.oop.family_tree.human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getBirthDate().equals(o2.getBirthDate())) {
            return 0;
        }
        return o1.getBirthDate().before(o2.getBirthDate()) ? 1 : -1;
    }
}
