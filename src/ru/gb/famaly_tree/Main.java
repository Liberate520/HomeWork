package ru.gb.famaly_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Human h1 = new Human("имя1",Gender.male,LocalDate.of(2000,01,02),LocalDate.of(2024,01,01),null,null,null);
        Human h2 = new Human("имя2",Gender.female,LocalDate.of(2000,01,02),null,null,null,null);
        System.out.println(h2.Age());
    }
}
