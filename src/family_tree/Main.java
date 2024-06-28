package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human vugar = new Human("Вугар", Gender.Male, LocalDate.of(1968, 1, 10));
        Human lamiya = new Human("Ламия", Gender.Female, LocalDate.of(1972, 9, 29));

        tree.add(vugar);
        tree.add(lamiya);
        tree.setWedding(vugar, lamiya);

        Human azer = new Human("Азер", Gender.Male, LocalDate.of(1995, 3, 5),
                vugar, lamiya);
        Human arzu = new Human("Арзу", Gender.Female, LocalDate.of(1996, 8, 30),
                vugar, lamiya);
        Human anar = new Human("Анар", Gender.Male, LocalDate.of(1999, 11, 25),
                vugar, lamiya);

        tree.add(azer);
        tree.add(arzu);
        tree.add(anar);

        Human lala = new Human("Лала", Gender.Female, LocalDate.of(1949, 6, 23));
        lala.addChild(lamiya);

        tree.add(lala);

        System.out.println(tree);
    }
}
