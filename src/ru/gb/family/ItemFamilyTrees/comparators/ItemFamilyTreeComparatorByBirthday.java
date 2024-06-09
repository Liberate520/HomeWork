package ru.gb.family.ItemFamilyTrees.comparators;

import ru.gb.family.ItemFamilyTrees.ItemFamilyTree;

import java.util.Comparator;

public class ItemFamilyTreeComparatorByBirthday implements Comparator<ItemFamilyTree> {
    @Override
    public int compare(ItemFamilyTree o1, ItemFamilyTree o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}

