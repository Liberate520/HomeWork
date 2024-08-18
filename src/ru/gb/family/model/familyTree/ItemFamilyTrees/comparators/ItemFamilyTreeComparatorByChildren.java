package ru.gb.family.model.familyTree.ItemFamilyTrees.comparators;

import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.Comparator;

public class ItemFamilyTreeComparatorByChildren implements Comparator<ItemFamilyTree> {
    @Override
    public int compare(ItemFamilyTree o1, ItemFamilyTree o2) {
        return (o1.getChildren().size() < o2.getChildren().size() ? -1 : (o1.getChildren().size() > o2.getChildren().size() ? 1 : 0));
    }
}
