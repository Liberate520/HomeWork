package ru.gb.family_tree;

import ru.gb.family_tree.dataHandler.FileHandler;
import ru.gb.family_tree.dataHandler.Writeble;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree ft = new FamilyTree<>();

        Human Adam = new Human("Adam", null, null, LocalDate.of(2000, 1, 1 ), LocalDate.of(3000, 12, 30 ), Gender.M);
        ft.addHuman(Adam);
        Human Eve = new Human("Eve", null, null, LocalDate.of(2000, 1, 1 ), LocalDate.of(3000, 12, 30 ), Gender.F);
        ft.addHuman(Eve);
        Human Son1 = new Human("Son1", Eve, Adam, LocalDate.of(2005, 2, 22 ), LocalDate.of(3022, 7, 7 ), Gender.M);
        ft.addHuman(Son1);
        //кровосмешение Евы со своим сыном
        Human Gdau1 = new Human("Gdau1", Eve, Son1, LocalDate.of(2055, 3, 3 ), null, Gender.F);
        ft.addHuman(Gdau1);

        Human Dau2 = new Human("Eve", LocalDate.of(2066, 12, 12), Gender.F);
        ft.addHuman(Dau2);

//        System.out.println(ft);
//        System.out.println(Eve);
//        System.out.println(Eve.getAge());
//        System.out.println(Son1.getParents());
//        System.out.println(ft.getFullTree());
//        System.out.println(ft.findHuman("Eve"));
//
//        Writeble writeble = new FileHandler();
//        writeble.writeData(ft, "ft");
//        //создаем новый объект FamilyTree на основе файла:
//        FamilyTree ft_restored = (FamilyTree) writeble.readData("ft");
//        System.out.println("Данные из файла:");
//        System.out.println(ft_restored.getFullTree());

        //проверка Iterable
        for(Object human: ft){
            System.out.println(human);
        }

        System.out.println("\nСортировка по возрасту");
        ft.sortByAge();
        System.out.println(ft.getFullTree());
        System.out.println("Сортировка по имени");
        ft.sortByName();
        System.out.println(ft.getFullTree());
        System.out.println("Сортировка по кол-ву детей");
        ft.sortByChild();
        System.out.println(ft.getFullTree());
    }
}
