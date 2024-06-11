package ru.gb.family.familyTree;





import ru.gb.family.familyTree.ItemFamilyTrees.genTest.GeneratItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.ArrayList;
import java.util.List;

public class GeneratFamalyTree {
    public GeneratFamalyTree() {
        List<ItemFamilyTree> newItemFamilyTree = new ArrayList<>();
    }

    public FamilyTree gen() {
        FamilyTree familyTree = new FamilyTree();
        GeneratItemFamilyTree genItem = new GeneratItemFamilyTree();
        for (ItemFamilyTree newItem: genItem.GeneratItemFamilyTree()) {
            familyTree.addItemFamilyTreeInTree(newItem);
        }
        return familyTree;
    }
}