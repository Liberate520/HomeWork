package ru.gb.family.familyTree.ItemFamilyTrees.genTest;

import ru.gb.family.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeneratItemFamilyTree {
    public GeneratItemFamilyTree() {
        List<ItemFamilyTree> newItemFamilyTree = new ArrayList<>();
    }

    public List<ItemFamilyTree> GeneratItemFamilyTree() {
        List<ItemFamilyTree> newItemFamilyTree = new ArrayList<>();
        ItemFamilyTree itemFamilyTree1 = new ItemFamilyTree("Васильев Роман Максимович", LocalDate.of(2015, 5, 6), null, Gender.Male);
        ItemFamilyTree itemFamilyTree2 = new ItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21), null, Gender.Male);
        ItemFamilyTree itemFamilyTree3 = new ItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17), null, Gender.Female);

        ItemFamilyTree itemFamilyTree4 = new ItemFamilyTree("Васильева Алина Андреевна", LocalDate.of(2018, 3, 8), null, Gender.Female);
        ItemFamilyTree itemFamilyTree5 = new ItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1), null, Gender.Male);
        ItemFamilyTree itemFamilyTree6 = new ItemFamilyTree("Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11), null, Gender.Female);

        ItemFamilyTree itemFamilyTree7 = new ItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15), LocalDate.of(2010, 5, 1), Gender.Male);
        ItemFamilyTree itemFamilyTree8 = new ItemFamilyTree("Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28), null, Gender.Female);

        itemFamilyTree1.editItemFamilyTree(itemFamilyTree2, DegreeOfKinship.Father);
        itemFamilyTree1.editItemFamilyTree(itemFamilyTree3, DegreeOfKinship.Mother);
        itemFamilyTree2.editItemFamilyTree(itemFamilyTree3, DegreeOfKinship.Spouse);

        itemFamilyTree4.editItemFamilyTree(itemFamilyTree5, DegreeOfKinship.Father);
        itemFamilyTree4.editItemFamilyTree(itemFamilyTree6, DegreeOfKinship.Mother);
        itemFamilyTree5.editItemFamilyTree(itemFamilyTree6, DegreeOfKinship.Spouse);

        itemFamilyTree7.editItemFamilyTree(itemFamilyTree2, DegreeOfKinship.Children);
        itemFamilyTree7.editItemFamilyTree(itemFamilyTree5, DegreeOfKinship.Children);
        itemFamilyTree8.editItemFamilyTree(itemFamilyTree2, DegreeOfKinship.Children);
        itemFamilyTree8.editItemFamilyTree(itemFamilyTree5, DegreeOfKinship.Children);

        itemFamilyTree7.editItemFamilyTree(itemFamilyTree8, DegreeOfKinship.Spouse);

        newItemFamilyTree.add(itemFamilyTree1);
        newItemFamilyTree.add(itemFamilyTree2);
        newItemFamilyTree.add(itemFamilyTree3);
        newItemFamilyTree.add(itemFamilyTree4);
        newItemFamilyTree.add(itemFamilyTree5);
        newItemFamilyTree.add(itemFamilyTree6);
        newItemFamilyTree.add(itemFamilyTree7);
        newItemFamilyTree.add(itemFamilyTree8);
        return newItemFamilyTree;
    }


}
