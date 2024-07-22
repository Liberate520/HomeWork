package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanChildrenCountComparator implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h2.getChildren().size(), h1.getChildren().size()); // Сортировка по убыванию количества детей
    }
}
