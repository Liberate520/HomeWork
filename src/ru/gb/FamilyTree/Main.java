package ru.gb.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();

        Human vasiliy = new Human("Василий", Gender.Male,
                LocalDate.of(1955, 8, 5), null,null,null);
        Human tamara = new Human("Тамара", Gender.Female,
                LocalDate.of(1957, 1, 6),null,null,null);

        newTree.add(vasiliy);
        newTree.add(tamara);

        Human andrej = new Human("Андрей",Gender.Male,
                LocalDate.of(1984, 5, 5),null,null,null);

        newTree.add(andrej);

        System.out.println(newTree);
    }
}

