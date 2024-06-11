package ru.gb.family.familyTree.ItemFamilyTrees.comparators;

import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.Comparator;

public class ItemFamilyTreeComparatorByAge implements Comparator<ItemFamilyTree> {

    @Override
    public int compare(ItemFamilyTree o1, ItemFamilyTree o2) {
        return (o1.getAge() < o2.getAge() ? -1 : (o1.getAge() > o2.getAge() ? 1 : 0));
    }
}
