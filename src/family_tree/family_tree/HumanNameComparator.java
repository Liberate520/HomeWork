package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
