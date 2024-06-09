package ru.gb.family.ItemFamilyTrees.comparators;

import ru.gb.family.ItemFamilyTrees.ItemFamilyTree;

import java.util.Comparator;

public class ItemFamilyTreeComparatorByAge implements Comparator<ItemFamilyTree> {

    @Override
    public int compare(ItemFamilyTree o1, ItemFamilyTree o2) {
        return (o1.getAge() < o2.getAge() ? -1 : (o1.getAge() > o2.getAge() ? 1 : 0));
    }
}
