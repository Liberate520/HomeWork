package ru.gb.FamilyTree;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human(1,"Александр", Gender.Male,  LocalDate.of(1960, 10, 10));
        Human human2 = new Human(2,"Екатерина", Gender.Female,  LocalDate.of(1965, 05, 05));
        Human human3 = new Human(3,"Михаил", Gender.Male,  LocalDate.of(1985, 06, 15));
        Human human4 = new Human(4,"Евгения", Gender.Female,  LocalDate.of(1990, 12, 25));
        Human human5 = new Human(5,"Геннадий", Gender.Male,  LocalDate.of(2015, 7, 7));

        human1.setChildren(List.of(human3));
        human2.setChildren(List.of(human3));
        human3.setParents(List.of(human1, human2));
        human3.setChildren(List.of(human5));
        human4.setChildren(List.of(human5));
        human5.setParents(List.of(human3, human4));
        human2.setDeathDate(LocalDate.of(2020, 3,25));



        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println(human4);
        System.out.println(human5);

    }


}
