package ru.gb.famaly_tree.human;

import java.util.Comparator;

public class HumanComporatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.Age(), o2.Age());
    }
}
