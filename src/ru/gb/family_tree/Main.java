package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Human Ivan = new Human("Ivan", Gender.Male, LocalDate.of(2000, 3, 3));
        Human Iana = new Human("Iana", Gender.Female, LocalDate.of(2000, 8,9));
        Human child1 = new Human("Elena", Gender.Female, LocalDate.of(2022,3,7));
        Human child2 = new Human("Igor", Gender.Male, LocalDate.of(2024, 4,4));
    }
}
