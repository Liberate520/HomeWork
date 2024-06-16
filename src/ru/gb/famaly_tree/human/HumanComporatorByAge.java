package ru.gb.famaly_tree.human;

import java.util.Comparator;

public class HumanComporatorByAge<T extends DutiesOfTheCreature<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.Age(), o2.Age());
    }
}
