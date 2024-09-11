package ru.gb.FamilyTree;

import ru.gb.FamilyTree.family_tree.FamilyTree;
import ru.gb.FamilyTree.person.Gender;
import ru.gb.FamilyTree.person.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

        Person ivan = new Person("Иванов", "Иван", Gender.Male, LocalDate.parse("1989-10-31"));
        Person petr = new Person("Иванов", "Петр", Gender.Male, LocalDate.parse("1962-05-15"));
        Person anna = new Person("Смирнова", "Анна", Gender.Female, LocalDate.parse("1964-06-28"));
        Person ekaterina = new Person("Иванова", "Екатерина", Gender.Female, LocalDate.parse("1991-11-02"), petr, anna);

        ft.addPerson(petr);
        ft.addPerson(anna);
        ft.setAddSpouses(petr, anna);

        ft.addPerson(ivan);
        ivan.setFather(petr);
        ivan.setMother(anna);

        petr.addChild(ivan);
        anna.addChild(ivan);

        ft.addPerson(ekaterina);

        Person sveta = new Person("Волкова", "Светлана", Gender.Female, LocalDate.parse("1990-02-21"));

        ft.addPerson(sveta);
        ft.setAddSpouses(ivan, sveta);

        Person gleb = new Person("Иванов", "Глеб", Gender.Male, LocalDate.parse("2017-11-01"), ivan,sveta);

        ft.addPerson(gleb);


        System.out.println(ft);

    }

}
