package ru.gb.family.familyTree.ItemFamilyTrees.genTest;

import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.humans.Human;
import ru.gb.family.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeneratItemFamilyTree<T extends ItemFamilyTree<T>> {
    public GeneratItemFamilyTree() {
        List<ItemFamilyTree<Human>> newItemFamilyTree = new ArrayList<>();
    }

    public FamilyTree gen() {

        //FamilyTree<T> testfamilyTree = new FamilyTree<>();
        Service testService = new Service<FamilyTree, T>();

        testService.creatItemFamilyTree("Васильев Роман Максимович", LocalDate.of(2015, 5, 6),null, Gender.Male);
        testService.creatItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21), null, Gender.Male);
        testService.creatItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17), null, Gender.Female);

        testService.creatItemFamilyTree("Васильева Алина Андреевна", LocalDate.of(2018, 3, 8), null, Gender.Female);
        testService.creatItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1), null, Gender.Male);
        testService.creatItemFamilyTree("Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11), null, Gender.Female);

        testService.creatItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15), LocalDate.of(2010, 5, 1),  Gender.Male);
        testService.creatItemFamilyTree("Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28), null, Gender.Female);

        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильев Роман Максимович",LocalDate.of(2015, 5, 6)),testService.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Father);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильев Роман Максимович",LocalDate.of(2015, 5, 6)),testService.getItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17)), DegreeOfKinship.Mother);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)),testService.getItemFamilyTree("Васильева Татьяна Владимировна", LocalDate.of(1987, 10, 17)), DegreeOfKinship.Spouse);

        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Алина Андреевна", LocalDate.of(2018, 3, 8)),testService.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Father);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Алина Андреевна", LocalDate.of(2018, 3, 8)),testService.getItemFamilyTree("Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11)), DegreeOfKinship.Mother);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Наталья Николаевна", LocalDate.of(1988, 7, 11)),testService.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Spouse);

        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)),testService.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Children);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)),testService.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Children);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testService.getItemFamilyTree("Васильев Андрей Николаевич", LocalDate.of(1990, 8, 1)), DegreeOfKinship.Children);
        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testService.getItemFamilyTree("Васильев Максим Николаевич", LocalDate.of(1986, 6, 21)), DegreeOfKinship.Children);

        testService.editItemFamilyTree(testService.getItemFamilyTree( "Васильева Надежда Николаевна", LocalDate.of(1954, 1, 28)),testService.getItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)), DegreeOfKinship.Spouse);
        return  testService.getFamilyTree();
    }


}
