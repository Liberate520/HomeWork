package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familytree = new FamilyTree();
        Human Natasha = new Human("Anastasia", Gender.Female, LocalDate.of(1952, 2, 8));
        Human Ivan = new Human("Ivan", Gender.Male, LocalDate.of(1950, 5, 12));
        Human Galina = new Human("Galina", Gender.Female, LocalDate.of(1947, 5, 15));
        familytree.addRalative(Natasha);
        familytree.addRalative(Ivan);
        familytree.addRalative(Galina);
        Human Anatoly = new Human("Anatoly", Gender.Male, LocalDate.of(1976, 11, 4), Natasha, Ivan);
        familytree.addRalative(Natasha);
        familytree.addRalative(Anatoly);
        Human Nastya = new Human("Nastya", Gender.Female, LocalDate.of(1998, 5,11), Natasha, Anatoly);

        familytree.addRalative(Nastya);


        System.out.println(familytree);

    }


}