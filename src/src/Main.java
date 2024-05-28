package src;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1995, 1, 1));
        Human sergej = new Human("Сергей", Gender.Male, LocalDate.of(1993, 5, 5));


        tree.add(maria);
        tree.add(sergej);

        Human misha = new Human("Миша", Gender.Male, LocalDate.of(2014, 12, 24));

        tree.add(misha);

        Human ded = new Human("Дед Валера", Gender.Male, LocalDate.of(1950, 4, 19));

        System.out.println(tree);
    }
}