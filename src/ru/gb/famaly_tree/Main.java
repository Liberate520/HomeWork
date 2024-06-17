package ru.gb.famaly_tree;

import ru.gb.famaly_tree.model.filehandler.FileHandler;
import ru.gb.famaly_tree.model.filehandler.Writable;
import ru.gb.famaly_tree.model.ft.Famaly_tree;
import ru.gb.famaly_tree.model.human.Gender;
import ru.gb.famaly_tree.model.human.Human;
import ru.gb.famaly_tree.view.ConsoleUI;
import ru.gb.famaly_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();

        //Writable writable = new FileHandler();
        /*
        Визуализация тестового дерева
                ?       ?
                \      /
                (h1)+(h2)
         ?        /   \        ?
         \       /     \      /
         (h32)+(h31)   (h3)+(h4)    ?
              |            \       /
            (h311)         (h5)+(h6)     ?
                                \       /
                                (h7)+(h8)
                                    |
                                   (h9)
         */


        //создание экземпляров класса human
        ///*
//        Human h1 = new Human("имя1", Gender.male,LocalDate.of(1940,3,5),LocalDate.of(2010,1,4));
//        Human h2 = new Human("имя2",Gender.female,LocalDate.of(1940,7,23),LocalDate.of(2009,10,8));
//
//        Human h31 = new Human("имя3.1",Gender.male,LocalDate.of(1960,4,15),LocalDate.of(2021,12,11));
//
//        Human h3 = new Human("имя3",Gender.male,LocalDate.of(1960,12,9),LocalDate.of(2018,9,23));
//        Human h4 = new Human("имя4",Gender.female,LocalDate.of(1960,10,31),null);
//
//        Human h5 = new Human("имя5",Gender.male,LocalDate.of(1980,11,6),null);
//        Human h6 = new Human("имя6",Gender.female,LocalDate.of(1980,1,4),null);
//
//        Human h7 = new Human("имя7",Gender.male,LocalDate.of(2000,6,18),null);
//        Human h8 = new Human("имя8",Gender.female,LocalDate.of(2000,2,25),null);
//
//        Human h9 = new Human("имя9",Gender.female,LocalDate.of(2020,7,7),null,h8,h7,null);
//
//        Human h32 = new Human("имя3.2",Gender.female,LocalDate.of(1980,5,30),LocalDate.of(2021,12,11));
//        Human h311 = new Human("имя3.1.1",Gender.male,LocalDate.of(1980,11,6),null,h32,h31,null);
//
//        //создание дерева
//        Famaly_tree<Human> famaly1 = new Famaly_tree<>();
//        famaly1.addFounder(h1);
//
//        //добавление детей h3 и h31 к родителю h2
//        famaly1.addThisInThis(h3,h2);
//        famaly1.addThisInThis(h31,h2);
//
//        //добавление пары мужчина-женщина h1 и h2
//        famaly1.coupl(h1,h2);
//
//        //остальные по аналогии
//        famaly1.addThisInThis(h5,h4);
//        famaly1.coupl(h3,h4);
//
//        famaly1.addThisInThis(h7,h6);
//        famaly1.coupl(h5,h6);
//
//        famaly1.addThisInThis(h9,h8);
//        famaly1.coupl(h7,h8);
//
//        famaly1.addThisInThis(h311,h32);
//        famaly1.coupl(h31,h32);
//        System.out.println(famaly1.searchByName("имя1").ToString());
//
//        //вывод информации о персоне
//        System.out.println(h1.ToString());
//        System.out.println("__________________");
//        System.out.println(h2.ToString());
//        System.out.println("__________________");
//        System.out.println(h3.ToString());
//        System.out.println("__________________");
//        System.out.println(h31.ToString());
//        System.out.println("__________________");
//        System.out.println(h4.ToString());
//        System.out.println("__________________");
//        System.out.println(h5.ToString());
//        System.out.println("__________________");
//        System.out.println(h6.ToString());
//        System.out.println("__________________");
//        System.out.println(h7.ToString());
//        System.out.println("__________________");
//        System.out.println(h8.ToString());
//        System.out.println("__________________");
//        System.out.println(h9.ToString());
//        System.out.println("__________________");
//        System.out.println(h32.ToString());
//        System.out.println("__________________");
//        System.out.println(h311.ToString());
//        System.out.println("__________________");
//
//
//        writable.saved(famaly1);
//        System.out.println(famaly1.printFamalyTree(h1));
//
//        System.out.println(famaly1.humanListToString());
//
//        System.out.println(famaly1.humanListToString(famaly1.sortByAge(false)));
//        System.out.println(famaly1.humanListToString(famaly1.sortByChildrenCount(false)));
//        System.out.println(famaly1.humanListToString(famaly1.sortByName(false)));
//        System.out.println();
//        System.out.println(famaly1.humanListToString(famaly1.sortByAge(true)));
//        System.out.println(famaly1.humanListToString(famaly1.sortByChildrenCount(true)));
//        System.out.println(famaly1.humanListToString(famaly1.sortByName(true)));

        //*/
        //закомментровать все что выше и раскомментировать ниже. Далее проиходит загрузка и вывод информации о персоне h1 и его семейного дерева
        //Famaly_tree famaly1 = writable.download();
        //famaly1.printPersona(famaly1.GetFounder());
        //famaly1.printFamalyTree(famaly1.GetFounder());
    }
}
//https://github.com/NukeTree3/homeWorkFamalyTree.git