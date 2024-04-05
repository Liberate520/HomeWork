package FamilyTree.HomeWork.src;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Family familytree = new Family();
        Human Vyacheslav = new Human("Vyacheslav", Gender.Male, LocalDate.of(1951, 10, 13));
        Human Valentina = new Human("Valentina", Gender.Female, LocalDate.of(1954, 5, 20), LocalDate.of(2018, 2, 26), null, null);
        familytree.addRalative(Vyacheslav);
        familytree.addRalative(Valentina);
        Human Olga = new Human("Olga", Gender.Female, LocalDate.of(1975, 1, 24), null, Vyacheslav);
        Human Alexey = new Human("Alexey", Gender.Male, LocalDate.of(1974, 8, 1), Valentina, null);
        familytree.addRalative(Olga);
        familytree.addRalative(Alexey);
        Human Kristina = new Human("Kristina", Gender.Female, LocalDate.of(1997, 1, 9), Olga, Alexey);
        Human Ekaterina = new Human("Ekaterina", Gender.Female, LocalDate.of(1999, 2,4), Olga, Alexey);
        familytree.addRalative(Kristina);
        familytree.addRalative(Ekaterina);
        Human Daria = new Human("Daria", Gender.Female, LocalDate.of(2017, 12, 30), Kristina, null);
        familytree.addRalative(Daria);


        System.out.println(familytree);

    }


}