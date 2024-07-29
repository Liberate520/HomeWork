package ru.gb.familytree.model.human;

import java.time.LocalDate;
import java.util.Comparator;

public class HumanComparatorByAge<T extends SomeBody> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAgeAgo(), o2.getAgeAgo());
    }
}
