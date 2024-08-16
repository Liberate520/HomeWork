package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = testTree();
        System.out.println(familyTree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1990, 1, 1));
        Human dasha = new Human("Дарья", Gender.Female, LocalDate.of(1991, 2, 2));

        tree.add(vasya);
        tree.add(dasha);
        tree.setWedding(vasya, dasha);

        Human oleg = new Human("Олег", Gender.Male, LocalDate.of(1997, 9, 9));

        tree.add(oleg);

        Human larisa = new Human("Лариса", Gender.Female, LocalDate.of(1960, 3, 3));
        larisa.addChild(oleg);
        tree.add(larisa);

        return tree;
    }
}
