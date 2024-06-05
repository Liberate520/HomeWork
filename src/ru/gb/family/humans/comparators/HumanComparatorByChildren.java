package ru.gb.family.humans.comparators;

import ru.gb.family.humans.Human;

import java.util.Comparator;

public class HumanComparatorByChildren implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return (o1.getChildren().size() < o2.getChildren().size() ? -1 : (o1.getChildren().size() > o2.getChildren().size() ? 1 : 0));
    }
}
