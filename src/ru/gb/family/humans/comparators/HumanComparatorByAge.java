package ru.gb.family.humans.comparators;

import ru.gb.family.humans.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return (o1.getAge() < o2.getAge() ? -1 : (o1.getAge() > o2.getAge() ? 1 : 0));
    }
}
