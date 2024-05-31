package ru.gb.family_tree;

import ru.gb.family_tree.Human.Human;

import java.util.Comparator;

public class ComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
