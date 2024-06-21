package ru.gb.family.model.familyTree.ItemFamilyTrees.comparators;

import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.Comparator;

public class ItemFamilyTreeComparatorByName implements Comparator<ItemFamilyTree> {
    @Override
    public int compare(ItemFamilyTree o1, ItemFamilyTree o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
