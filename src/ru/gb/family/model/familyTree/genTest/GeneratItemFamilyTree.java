package ru.gb.family.model.familyTree.genTest;

import ru.gb.family.model.familyTree.FamilyTree;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.time.LocalDate;

public class GeneratItemFamilyTree<T extends ItemFamilyTree<T>> {
   // public GeneratItemFamilyTree() {
   //     List<ItemFamilyTree<Human>> newItemFamilyTree = new ArrayList<>();
   // }

    public FamilyTree gen() {
        long id = 0;
        FamilyTree testFamily = new FamilyTree<>();
        testFamily.creatItemFamilyTreeInTree(id++,"Васильев Роман Максимович", LocalDate.of(2015, 5, 6),null, Gender.Male);
        testFamily.creatItemFamilyTreeInTree(id++,"Васильев Максим Николаевич", LocalDate.of(1986, 6, 21), null, Gender.Male);
        testFamily.creatItemFamilyTreeInTree(id++,"Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17), null, Gender.Female);

        testFamily.creatItemFamilyTreeInTree(id++,"Васильева Алина Андреевна", LocalDate.of(2018, 3, 8), null, Gender.Female);
        testFamily.creatItemFamilyTreeInTree(id++,"Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1), null, Gender.Male);
        testFamily.creatItemFamilyTreeInTree(id++,"Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11), null, Gender.Female);

        testFamily.creatItemFamilyTreeInTree(id++,"Васильев Николай Михайлович", LocalDate.of(1954, 1, 15), LocalDate.of(2010, 5, 1),  Gender.Male);
        testFamily.creatItemFamilyTreeInTree(id++,"Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28), null, Gender.Female);


        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree( "Васильев Роман Максимович",LocalDate.of(2015, 5, 6)),testFamily.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Father);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильев Роман Максимович",LocalDate.of(2015, 5, 6)),testFamily.getItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17)), DegreeOfKinship.Mother);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)),testFamily.getItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17)), DegreeOfKinship.Spouse);

        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Алина Андреевна", LocalDate.of(2018, 3, 8)),testFamily.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Father);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Алина Андреевна", LocalDate.of(2018, 3, 8)),testFamily.getItemFamilyTree("Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11)), DegreeOfKinship.Mother);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11)),testFamily.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Spouse);

        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)),testFamily.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Children);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)),testFamily.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Children);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testFamily.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Children);
        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testFamily.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Children);

        testFamily.editItemFamilyTree(testFamily.getItemFamilyTree(  "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testFamily.getItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)), DegreeOfKinship.Spouse);
        //System.out.println(testService.getFamilyTree());

        return  testFamily;

    }


}
