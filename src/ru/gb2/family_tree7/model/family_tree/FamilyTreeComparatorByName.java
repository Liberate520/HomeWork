package ru.gb2.family_tree7.model.family_tree;

import ru.gb2.family_tree7.model.human.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
