package ru.gb.family;

import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.humans.enums.DegreeOfKinship;
import ru.gb.family.humans.enums.Gender;
import ru.gb.family.humans.Human;
import ru.gb.family.service.Service;

import java.io.Serializable;
import java.time.LocalDate;


public class Main implements Serializable {

    public static void main(String[] args) {
        String saveFilePath = "src/ru/gb/family/data/FamilyTree.txt";
        Service service = new Service();
        FamilyTree familyTree = Service.start(saveFilePath);

        Human humanSearch = new Human("Васильев Николай Михайлович", LocalDate.of(1954, 1, 15), LocalDate.of(2010, 5, 1), Gender.Male);
        //Разные виды сортировки списка древа семьи
        //familyTree.sortByAge();
        //familyTree.sortByBirthday();
        //familyTree.sortByChildren();
        familyTree.sortByName();

        System.out.println(familyTree);

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по совпадению в ФИО");
        System.out.println(familyTree.printResult(familyTree.searchByName ("Роман")));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по гендору");
        System.out.println(familyTree.printResult(familyTree.searchByGender(Gender.Female)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выполняем поиск по степени родства");
        System.out.println(familyTree.printResult(familyTree.searchByDegreeOfKinship(DegreeOfKinship.Father)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Проверяем есть ли человек в семейном древе");
        System.out.println(familyTree.printResult(familyTree.searchByHuman(humanSearch)));

        System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Покациваем список детей человека из семейного древа");
        System.out.println(familyTree.findChildrenHuman(humanSearch));

        Service.save(familyTree, saveFilePath);
    }





}