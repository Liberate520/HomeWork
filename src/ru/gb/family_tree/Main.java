package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

//        Адреса файла для записи/чтения:
        String path1 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_name.out";
        String path2 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_age.out";

//        Инициализируем экземпляр класса для записи/чтения:
        FileHandler fileHandler = new FileHandler();

//        Инициализируем экземпляр класса семейного древа:
        FamilyTree<Human> familyTree = testTree();

        System.out.println("\nДанные из семейного древа ДО чтения из файла:\n");
        System.out.println(familyTree);

        System.out.println("---------");
        System.out.println("Sorted by Name:\n");

        familyTree.sortByName();
        System.out.println(familyTree);

//  ---------------------------------------
//        Запись в файл:
        fileHandler.write(familyTree, path1);

//  ------------------------------------

        System.out.println("Sorted by Age:\n");

        familyTree.sortByAge();
        System.out.println(familyTree);

//  ---------------------------------------
//        Запись в файл:
        fileHandler.write(familyTree, path2);

//  ------------------------------------

//  ------------------------------------

//        Чтение из файла:
        FamilyTree<Human> familyTreeRestored1 = (FamilyTree<Human>) fileHandler.read(path1);
        System.out.println("\nДанные из семейного древа c сортировкой по имени\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored1);

//  ------------------------------------

//        Чтение из файла:
        FamilyTree<Human> familyTreeRestored2 = (FamilyTree<Human>) fileHandler.read(path2);
        System.out.println("\nДанные из семейного древа c сортировкой по возрасту\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored2);
    }

//  ---------------------------------------------


//    -------------------------------------------

     static FamilyTree<Human> testTree() {
        FamilyTree<Human> familyTree = new FamilyTree<>();

//        Human human1 = new Human("Иванов Валерий Петрович", Gender.male, LocalDate.of(1978, 4, 11));
//        Human human2 = new Human("Максимов Петр Геннадьевич", Gender.male, LocalDate.of(1957, 12,4), LocalDate.of(1999, 6, 12));
//        Human human3 = new Human("Макарова Инна Сергеевна", Gender.female, LocalDate.of(1958, 9,4), LocalDate.of(2001, 9, 19));
//        Human human4 = new Human("Максимов Валерий Петрович", Gender.male, LocalDate.of(1988, 5, 7));
//        Human human5 = new Human("Максимова Анна Петровна", Gender.female, LocalDate.of(1991, 11, 13));
//        Human human6 = new Human("Родионова Анастасия Павловна", Gender.female, LocalDate.of(1960, 12, 1));


        Human human1 = new Human("Иванов Валерий Петрович", Gender.male, LocalDate.of(1978, 4, 11));
        Human human2 = new Human("Максимов Петр Геннадьевич", Gender.male, LocalDate.of(1957, 12,4), LocalDate.of(1999, 6, 12));
        Human human3 = new Human("Макарова Инна Сергеевна", Gender.female, LocalDate.of(1958, 9,4), LocalDate.of(2001, 9, 19));
        Human human4 = new Human("Максимов Валерий Петрович", Gender.male, LocalDate.of(1988, 5, 7));
        Human human5 = new Human("Максимова Анна Петровна", Gender.female, LocalDate.of(1991, 11, 13));
        Human human6 = new Human("Родионова Анастасия Павловна", Gender.female, LocalDate.of(1960, 12, 1));

//        human1.PrintName();
//        human2.PrintName();
//
//        human3.PrintDob();
//        human4.PrintDob();
//
//        human3.PrintDod();
//        human4.PrintDod();
//
//        human1.PrintGender();
//        human3.PrintGender();
//
//        human1.PrintAge();
//        human2.PrintAge();
//
//        human2.PrintMother();
//        human3.PrintMother();
//
//        human2.PrintFather();
//        human3.PrintFather();
//
//        human4.PrintFather();
        human4.setFather(human2);
//        human4.PrintFather();

//        human4.PrintMother();
        human4.setMother(human3);
//        human4.PrintMother();

//        human5.PrintFather();
        human5.setFather(human2);
//        human5.PrintFather();

//        human5.PrintMother();
        human5.setMother(human3);
//        human5.PrintMother();

//        System.out.println("--------");

//        human2.PrintChildren();
        human2.addChild(human4);
//        human2.PrintChildren();
        human2.addChild(human5);
//        human2.PrintChildren();

//        human3.PrintChildren();
        human3.addChild(human4);
//        human3.PrintChildren();
        human3.addChild(human5);
//        human3.PrintChildren();

//        System.out.println("--------");

//        human2.PrintSpouses();
        human2.addSpouse(human3, SpouseStatus.Ex);
//        human2.PrintSpouses();

//        human3.PrintSpouses();
        human3.addSpouse(human2, SpouseStatus.Actual);
//        human3.PrintSpouses();

//        human2.PrintSpouses();
        human2.addSpouse(human6, SpouseStatus.Actual);
//        human2.PrintSpouses();

//        System.out.println("--------");


//        System.out.println(human1);
//        System.out.println(human2);
//        System.out.println(human3);
//        System.out.println(human4);
//        System.out.println(human5);

//        System.out.println("--------");


        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);

//        human1.PrintId();

//        System.out.println("--------");


//        familyTree.findById(0);
//        familyTree.findById(3);

//        System.out.println("--------");


//        familyTree.findByName("Макарова Инна Сергеевна");

//        System.out.println("---------\n---------");

        return familyTree;
    }
}


//---------------------------------------------------------------------------------------
