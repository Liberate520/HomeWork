package ru.gb.family_tree.human;

import java.util.Comparator;

public class HumanComparatorByNumberOfChild implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getChild().size(), o1.getChild().size());
    }
}
