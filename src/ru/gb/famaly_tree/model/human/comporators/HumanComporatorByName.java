package ru.gb.famaly_tree.model.human.comporators;

import ru.gb.famaly_tree.model.human.DutiesOfTheCreature;

import java.util.Comparator;

public class HumanComporatorByName<T extends DutiesOfTheCreature<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
