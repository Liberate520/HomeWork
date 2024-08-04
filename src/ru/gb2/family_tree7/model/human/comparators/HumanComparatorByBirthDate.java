package ru.gb2.family_tree7.model.human.comparators;

import ru.gb2.family_tree7.model.group.GroupItem;
import ru.gb2.family_tree7.model.human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDate<T extends GroupItem> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        if (o1 == null || o2 == null) {
            throw new IllegalArgumentException("Нельзя сравнивать null");
        }
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}