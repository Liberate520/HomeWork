package ru.gb.family;

import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.cat.Cat;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.SortBy;
import ru.gb.family.familyTree.ItemFamilyTrees.humans.Human;
import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;

import ru.gb.family.service.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class Main implements Serializable {

    public static void main(String[] args) {

        String saveFilePath = "src/ru/gb/family/data/FamilyTree.txt";
        Service service = new Service();
        service.start(saveFilePath);

        service.getFamilyTree().sort(SortBy.Name); //Разные виды сортировки списка древа семьи {Age,Birthday,Children,Name}

        System.out.println(service.getFamilyTree());

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по совпадению в ФИО");
        System.out.println(service.getFamilyTree().printResult(service.getFamilyTree().searchByName ("Роман")));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по гендору");
        System.out.println(service.getFamilyTree().printResult(service.getFamilyTree().searchByGender(Gender.Female)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по степени родства");
        System.out.println(service.getFamilyTree().printResult(service.getFamilyTree().searchByDegreeOfKinship(DegreeOfKinship.Father)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Проверяем есть ли человек в семейном древе");
        System.out.println(service.getItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Показываем список детей человека из семейного древа");
        System.out.println(service.getFamilyTree().findChildrenItemFamilyTree(service.getItemFamilyTree("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15))));

        Service.save(service.getFamilyTree(), saveFilePath);

    }





}